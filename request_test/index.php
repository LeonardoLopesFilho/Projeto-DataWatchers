<?php

require_once 'ConnectDatabase.php'; 

$c = new ConnectDatabase(); 

$c->show($c->connect(),1); 

$c->show(
    $c->select('Dados')
); 