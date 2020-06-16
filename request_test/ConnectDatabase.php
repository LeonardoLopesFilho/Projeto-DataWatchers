<?php

/**
 * Classe desenvolvida para persistir dados em um BD
 * Parâmetros BD padrão: ./database/dbcon.ini
 */

class ConnectDatabase {

    /**
     * Faz a leitura de um arquivo de parâmetros (.ini) 
     * @method readIni()
     * @param String $iniFile Arquivo de parâmetros de conexão
     * @return Array [parâmetro] => [valor]
     */
    public function readIni($iniFile){
        
        $extension = ''; 
        for ($i = 4 ; $i >= 1 ; $i--) { 
            $extension.= $iniFile[strlen($iniFile)-$i]; 
        }
        $iniFile.= ($extension!='.ini') ? '.ini':'';

        $data = file_get_contents($iniFile); 
        $d = explode("\n",$data); 
        $param = []; 
        for ($i = 0; $i < count($d); $i++) {
            if ((strpos($d[$i],';') === false) && ((strlen($d[$i]) > 1) && ($d[$i] != ''))){
                $key = explode('=',$d[$i]); 
                // $param[$key[0]] = $key[1]; // Desativado pois considera o \n ao fim da string
                $param[$key[0]] = substr($key[1],0,strlen($key[1])-1); 
            }
        }
        return $param; 
    }
    /**
     * Executa a query no Banco de Dados definidos na parametrização do sistema
     * @param Object $connection Conexão com o serviço de Banco de Dados
     * @param String $query Query a ser executada no Banco de Dados
     * @return Array Resultado do Banco de Dados
     */
    private function runQuery($connection, $query){
        // Lançar Exception quando a conexão ou query forem inválidas
        $result = mysqli_query($connection, $query); 

        $a = []; 

        if ($result) {
            while($roster = mysqli_fetch_assoc($result)){
                $a[] = $roster; 
            }
        }        
        
        return $a; 
    }
    /**
     * Retorna a conexão ativa com o serviço de Banco de Dados
     * @method connect()
     * @param String $parms_connection Arquivo de parâmetros de conexão
     * @return Array [parâmetro] => [valor]
     */
    public function connect($parms_connection = false){

        // Utilizando API mysqli
        // Executa query no banco: mysqli_query(mysqli_connect(),$query)
        // Retorna o resultado da query em associative array: mysqli_fetch_assoc($result->mysqli_query())
        $parms = ($parms_connection) ? $parms_connection : './database/dbcon'; 
        
        $p = $this->readIni($parms); 

        $conect = mysqli_connect($p['host'],$p['user'],$p['password'],$p['database']); 

        return $conect; 
    }
    /**
     * Retorna o resultado da query no Banco de Dados, na tabela especificada em parâmetro
     * @param String $table Tabela onde será executada a query
     * @param Array $cols Array simples com as colunas desejadas
     * @return String Query que será executada
     */
    public function select($table, $cols = ['*']){
        
        $str = implode(', ', $cols); 
        $query = "SELECT ".$str.' FROM '.$table; 
        // echo $query; 

        return $this->runQuery($this->connect(), $query); 
    }
    /**
     * Retorna o resultado da query na tabela especificada obedecendo a cláusula WHERE
     * @param String $table Tabela onde será executada a query
     * @param Array $args Clásula WHERE [coluna] => [valor]
     * @param Integer $operator Une as cláusulas com operadores lógicos AND (1-default) / OR (2)
     * @param Array $cols Array simples com as colunas desejadas
     * @return String Query que será executada
     */
    public function select_where($table, $args, $cols = ['*'], $operator = 1) {
        if (!key_exists(0,$cols)) {
            $this->show('Parâmetro de colunas inválido. Utilize array simples não associativo.',1); 
        }
        
        $str = implode(', ', $cols); 
        
        $query = "SELECT ".$str.' FROM '.$table; 
        if(count($args) == 0){
            // Lançar exception
            $this->show('Como não há argumentos, utilize o método ConnectDatabase::select',1); 
        } else {
            $query.= ' WHERE '; 
            $loop = 1; 
            foreach ($args as $key => $value) {
                if($loop > 1){
                    $query.= ($operator == 2) ? ' OR ' : " AND "; 
                } 
                $query.= (is_string($value)) ? "$key = '$value'" : "$key = $value"; 
                $loop++; 
            }
        }
        // $this->show($query,0); 
        return $this->runQuery($this->connect(), $query); 
    }
    /**
     * Realiza a inserção de dados numa tabela do Banco de Dados
     * @param String $table Tabela onde será executada a query
     * @param Array $arr_values [coluna] => [valor]
     * @return String Query que será executada
     */
    public function insert($table, $arr_values){
        if (count($arr_values) == 0) {
            // Implementar lançamento de Exception
            return 'Impossivel realizar inserção sem parâmetros de valores. '; 
        }
        $columns = ''; 
        $values = ''; 
        $loop = 0; 
        foreach ($arr_values as $key => $value) {
            $columns.= $key; 
            $values.= (is_string($value)) ? "'$value'" : $value; 
            if($loop < count($arr_values)-1){
                $columns.= ', '; 
                $values.= ', '; 
            }
            $loop++; 
        }
        $query = "INSERT INTO $table ($columns) VALUES ($values)"; 
        // $this->show($query); 

        return $this->runQuery($this->connect(), $query); 
    }
    /**
     * Realiza a instrução update na tabela especificada em parâmetro
     * @param String $table Tabela onde será executada a query
     * @param Array $values Clásula SET [coluna] => [valor]
     * @param Array $args Clásula WHERE [coluna] => [valor]
     * @return String Query que será executada
     */
    public function update($table, $values, $args){
        if (count($values) == 0) {
            return 'Impossivel realizar update sem parâmetros de valores. '; 
        }
        $query = "UPDATE $table SET "; 
        $loop = 0; 
        foreach ($values as $key => $value) {
            $query.= (is_string($value)) ? "$key = '$value'" : $key.' = '.$value; 
            if ($loop != count($values)-1) {
                $query.= ', '; 
            }
            $loop++; 
        }
        $query.= " WHERE "; 
        if (count($args) == 0) {
            $query.= '1 = 1'; 
        } else{
            $loop = 0; 
            foreach ($args as $key => $value) {
                $query.= (is_string($value)) ? "$key = '$value'" : $key.' = '.$value; 
                if ($loop != count($args)-1) {
                    $query.= " AND "; 
                }
                $loop++; 
            }
        }
        // $this->show($query); 

        return $this->runQuery($this->connect(), $query); 
    } 
    /**
     * Deleta os registros da tabela de acordo com os parâmetros definidos
     * @param String $table Tabela onde será executada a query
     * @param Array $args Clásula WHERE [coluna] => [valor]
     * @return String Query que será executada
     */
    public function delete($table,$args){
        $query = "DELETE FROM ".$table; 
        if (count($args) == 0) {
            return $query; 
        }
        $query.= ' WHERE '; 
        $loop = 0; 
        foreach ($args as $key => $value) {
            $query.= (is_string($value)) ? "$key = '$value'" : $key.' = '.$value; 
            if ($loop != count($args)-1) {
                $query.= " AND "; 
                $loop++; 
            }
        }
        // $this->show($query); 

        return $this->runQuery($this->connect(), $query); 
    }
    /**
     * Mostra o conteúdo que se deseja teste. Função destinada apenas para ambiente de testes. 
     * @param Array|String|Numeric|Boolean $data Valor a ser exibido
     * @param Boolean $die Caso verdadeiro, encerra a execução do programa
     * @return String Tipo de dado recebido e seu valor
     */
    public function show($data, $die = 0){
        $div = "<div style='"; 
        $div.= 'border: solid 1px; '; 
        $div.= 'padding: 5px; '; 
        $div.= 'margin: 3px; '; 
        $div.= 'background-color: black; '; 
        $div.= 'color: white; '; 
        $div.= "'>"; 
        
        echo $div; 
        echo '<pre>'; 
        switch($data){
            case is_array($data):
                echo 'array('.count($data).')'; 
                break; 
            case is_string($data): 
                echo 'string('.strlen($data).')'; 
                break; 
            case is_object($data): 
                echo 'is a object'; 
                break; 
            default:
                echo var_dump($data); 
        }
        echo '</pre>'; 
        echo '<pre>'; 
        print_r($data); 
        echo '</pre>';         

        if($die){
            die('<small> O programa foi finalizado. </small>'); 
        }

        echo '</div>'; 
    }

}