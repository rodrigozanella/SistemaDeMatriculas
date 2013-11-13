CREATE DATABASE  IF NOT EXISTS `es_pratica3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `es_pratica3`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: es_pratica3
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `nomeUsuario_UNIQUE` (`nomeUsuario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  CONSTRAINT `nomeUsuario3` FOREIGN KEY (`nomeUsuario`) REFERENCES `usuario` (`nomeUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `matricula` int(8) DEFAULT NULL,
  `semestreIngresso` char(6) DEFAULT NULL,
  `metodoIngresso` varchar(45) DEFAULT NULL,
  `pontuacaoVestibular` int(11) DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `pontuacao` int(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `nomeUsuario_UNIQUE` (`nomeUsuario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  CONSTRAINT `nomeUsuario` FOREIGN KEY (`nomeUsuario`) REFERENCES `usuario` (`nomeUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES ('010.325.689-02','Rofrigo Zanella','rzanella','rodrigo@exemplo.com',NULL,NULL,NULL,NULL,NULL,NULL,500),('025.180.450-56','Henrique Dambros','hdambros','hvdambros@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,450),('100.252.666-99','Paulo dos Santos','psantos','paulo@uol.com',NULL,NULL,NULL,NULL,NULL,NULL,300);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correcao_conceito`
--

DROP TABLE IF EXISTS `correcao_conceito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correcao_conceito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpfProfessor` varchar(45) NOT NULL,
  `cpfAluno` varchar(45) NOT NULL,
  `idTurma` int(11) NOT NULL,
  `novoConceito` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cpfProfessor_idx` (`cpfProfessor`),
  KEY `cpfAluno_idx` (`cpfAluno`),
  KEY `cpfProfessor_idx2` (`cpfProfessor`),
  KEY `cpfProfessor_idx3` (`cpfProfessor`),
  KEY `idTurma_idx` (`idTurma`),
  CONSTRAINT `cpfAluno4` FOREIGN KEY (`cpfAluno`) REFERENCES `aluno` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cpfProfessor5` FOREIGN KEY (`cpfProfessor`) REFERENCES `professor` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTurma4` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correcao_conceito`
--

LOCK TABLES `correcao_conceito` WRITE;
/*!40000 ALTER TABLE `correcao_conceito` DISABLE KEYS */;
/*!40000 ALTER TABLE `correcao_conceito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `codigo` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `ehEletiva` bit(1) NOT NULL,
  `numCreditos` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('INF01023','Arquitetura e Desempenho de Banco de Dados','',4),('INF01032','Empreendimento em Informática','\0',4),('INF01120','Técnicas de Construção de Programas','\0',4),('INF01124','Classificação e Pesquisa de Dados','\0',4),('INF01142','Sistemas Operacionais I N','\0',4),('INF01145','Fundamentos de Banco de Dados','\0',4),('INF01147','Compiladores','\0',4),('INF01209','Fundamentos de Tolerância a Falhas','\0',4),('INF05516','Semântica Formal N','\0',4);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lance`
--

DROP TABLE IF EXISTS `lance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lance` (
  `idTurma` int(11) NOT NULL,
  `cpfAluno` varchar(45) NOT NULL,
  `valor` int(11) NOT NULL,
  `atendida` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idTurma`,`cpfAluno`),
  UNIQUE KEY `idTurma_UNIQUE` (`idTurma`),
  UNIQUE KEY `cpfAluno_UNIQUE` (`cpfAluno`),
  KEY `cpfAluno_idx` (`cpfAluno`),
  CONSTRAINT `cpfAluno2` FOREIGN KEY (`cpfAluno`) REFERENCES `aluno` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTurma3` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lance`
--

LOCK TABLES `lance` WRITE;
/*!40000 ALTER TABLE `lance` DISABLE KEYS */;
/*!40000 ALTER TABLE `lance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacao_administrador`
--

DROP TABLE IF EXISTS `operacao_administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacao_administrador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpfAdministrador` varchar(45) NOT NULL,
  `dataHora` datetime NOT NULL,
  `operacao` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `cpfAdministrador_UNIQUE` (`cpfAdministrador`),
  KEY `cpfAdministrador_idx` (`cpfAdministrador`),
  CONSTRAINT `cpfAdministrador` FOREIGN KEY (`cpfAdministrador`) REFERENCES `administrador` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacao_administrador`
--

LOCK TABLES `operacao_administrador` WRITE;
/*!40000 ALTER TABLE `operacao_administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `operacao_administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_requisito`
--

DROP TABLE IF EXISTS `pre_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_requisito` (
  `codigoDisciplina` varchar(45) NOT NULL,
  `codigoDisciplinaRequisito` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoDisciplina`,`codigoDisciplinaRequisito`),
  UNIQUE KEY `codigoDisciplina_UNIQUE` (`codigoDisciplina`),
  UNIQUE KEY `codigoDisciplinaRequisito_UNIQUE` (`codigoDisciplinaRequisito`),
  KEY `codigoDisciplinaRequisito_idx` (`codigoDisciplinaRequisito`),
  CONSTRAINT `disciplinaRequisito_codigo` FOREIGN KEY (`codigoDisciplinaRequisito`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `disciplina_codigo` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_requisito`
--

LOCK TABLES `pre_requisito` WRITE;
/*!40000 ALTER TABLE `pre_requisito` DISABLE KEYS */;
INSERT INTO `pre_requisito` VALUES ('INF01023','INF01145'),('INF01145','INF01124'),('INF01147','INF05516'),('INF01209','INF01142');
/*!40000 ALTER TABLE `pre_requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `areaInteresse` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `nomeUsuario_UNIQUE` (`nomeUsuario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  CONSTRAINT `nomeUsuario2` FOREIGN KEY (`nomeUsuario`) REFERENCES `usuario` (`nomeUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('001.002.003-04','Marcelo Pimenta','mpimenta@inf.ufrgs.br','mpimenta',NULL,NULL),('003.669.876-26','Manuel Oliveira','moliveira@inf.ufrgs.br','moliveira',NULL,NULL),('025.301.254-56','Mariana Luderitz Kolberg','mlkolberg@inf.ufrgs.br','mlkolberg',NULL,NULL),('032.256.215-89','Taisy Silva Weber','tsweber@inf.ufrgs.br','tsweber',NULL,NULL),('123.456.789-10','Sérgio Cechin','scechin@inf.ufrgs.br','scechin',NULL,NULL),('125.254.698-00','Lucas Schnorr','lschnorr@inf.ufrgs.br','lschnorr',NULL,NULL),('154.258.548-12','Cirano Iochpe','ciochpe@inf.ufrgs.br','cioshpe',NULL,NULL),('501.254.328-98','Luciana Porcher Nedel','lpnedel@inf.ufrgs.br','lpnedel',NULL,NULL);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistema`
--

DROP TABLE IF EXISTS `sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema` (
  `estado` varchar(45) NOT NULL,
  `semestre` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistema`
--

LOCK TABLES `sistema` WRITE;
/*!40000 ALTER TABLE `sistema` DISABLE KEYS */;
/*!40000 ALTER TABLE `sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` char(1) NOT NULL,
  `codigoDisciplina` varchar(45) NOT NULL,
  `horario` char(5) NOT NULL,
  `diasSemana` varchar(45) DEFAULT NULL,
  `semestre` char(6) NOT NULL,
  `numvagas` int(11) NOT NULL,
  `cpfProfessor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `codigoDisciplina_idx` (`codigoDisciplina`),
  KEY `cpfProfessor_idx` (`cpfProfessor`),
  CONSTRAINT `codigoDisciplina` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cpfProfessor` FOREIGN KEY (`cpfProfessor`) REFERENCES `professor` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'A','INF01124','10:30',NULL,'2013/2',40,'003.669.876-26'),(2,'B','INF01124','8:30',NULL,'2013/2',25,'003.669.876-26'),(3,'A','INF01124','13:30',NULL,'2013/1',30,'003.669.876-26'),(4,'A','INF01124','10:30',NULL,'2012/2',30,'003.669.876-26'),(5,'A','INF01124','13:30',NULL,'2012/1',25,'003.669.876-26'),(6,'A','INF05516','10:30',NULL,'2013/2',25,'025.301.254-56'),(7,'B','INF05516','8:30',NULL,'2013/2',20,'025.301.254-56'),(8,'A','INF05516','8:30',NULL,'2013/1',20,'025.301.254-56'),(9,'B','INF05516','13:30',NULL,'2013/1',20,'025.301.254-56'),(10,'A','INF05516','13:30',NULL,'2012/2',20,'025.301.254-56'),(11,'A','INF05516','10:30',NULL,'2012/1',30,'025.301.254-56'),(12,'A','INF01209','8:30',NULL,'2013/2',15,'032.256.215-89'),(13,'C','INF01209','15:30',NULL,'2013/2',10,'032.256.215-89'),(14,'D','INF01209','17:30',NULL,'2013/1',5,'032.256.215-89'),(15,'B','INF01209','10:30',NULL,'2012/2',15,'032.256.215-89'),(16,'A','INF01209','15:30',NULL,'2012/1',5,'032.256.215-89'),(17,'E','INF01209','19:30',NULL,'2011/2',50,'032.256.215-89'),(18,'A','INF01147','13:30',NULL,'2013/2',20,'125.254.698-00'),(19,'D','INF01147','10:30',NULL,'2013/2',15,'125.254.698-00'),(20,'C','INF01147','8:30',NULL,'2013/1',20,'125.254.698-00'),(21,'B','INF01147','10:30',NULL,'2013/1',15,'125.254.698-00'),(22,'A','INF01147','13:30',NULL,'2012/2',30,'125.254.698-00'),(23,'B','INF01147','8:30',NULL,'2012/1',15,'125.254.698-00'),(24,'A','INF01145','13:30',NULL,'2013/2',30,'154.258.548-12'),(25,'C','INF01145','10:30',NULL,'2013/2',20,'154.258.548-12'),(26,'C','INF01145','8:30',NULL,'2013/1',15,'154.258.548-12'),(27,'A','INF01145','13:30',NULL,'2012/2',20,'154.258.548-12'),(28,'A','INF01142','13:30',NULL,'2013/2',35,'123.456.789-10'),(29,'B','INF01142','10:30',NULL,'2013/2',30,'123.456.789-10'),(30,'A','INF01142','10:30',NULL,'2013/1',40,'123.456.789-10'),(31,'C','INF01142','8:30',NULL,'2012/2',15,'123.456.789-10'),(32,'A','INF01120','15:30',NULL,'2013/2',30,'001.002.003-04'),(33,'B','INF01120','13:30',NULL,'2013/2',15,'001.002.003-04'),(34,'A','INF01120','8:30',NULL,'2013/1',20,'001.002.003-04'),(35,'F','INF01120','10:30',NULL,'2012/2',5,'001.002.003-04'),(36,'U','INF01032','8:30',NULL,'2013/2',15,'501.254.328-98'),(37,'G','INF01032','13:30',NULL,'2013/1',5,'501.254.328-98'),(38,'U','INF01032','15:30',NULL,'2012/2',10,'501.254.328-98'),(39,'U','INF01032','13:30',NULL,'2012/1',20,'501.254.328-98'),(40,'U','INF01023','15:30',NULL,'2013/2',20,'154.258.548-12'),(41,'F','INF01023','13:30',NULL,'2013/1',15,'154.258.548-12'),(42,'U','INF01023','8:30',NULL,'2012/2',25,'154.258.548-12'),(43,'U','INF01023','15:30',NULL,'2011/2',15,'154.258.548-12');
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_cursada`
--

DROP TABLE IF EXISTS `turma_cursada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma_cursada` (
  `cpfAluno` varchar(45) NOT NULL,
  `idTurma` int(11) NOT NULL,
  `conceito` char(2) DEFAULT NULL,
  PRIMARY KEY (`cpfAluno`,`idTurma`),
  KEY `idTurma_idx` (`idTurma`),
  CONSTRAINT `cpfAluno` FOREIGN KEY (`cpfAluno`) REFERENCES `aluno` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTurma` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_cursada`
--

LOCK TABLES `turma_cursada` WRITE;
/*!40000 ALTER TABLE `turma_cursada` DISABLE KEYS */;
INSERT INTO `turma_cursada` VALUES ('010.325.689-02',5,'A'),('010.325.689-02',14,'A'),('010.325.689-02',27,'C'),('010.325.689-02',31,'B'),('010.325.689-02',39,'B'),('025.180.450-56',10,'B'),('025.180.450-56',38,'A');
/*!40000 ALTER TABLE `turma_cursada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nomeUsuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`nomeUsuario`),
  UNIQUE KEY `nomeUsuario_UNIQUE` (`nomeUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('cioshpe','1234','professor'),('hdambros','1234','aluno'),('lpnedel','1234','professor'),('lschnorr','1234','professor'),('mlkolberg','1234','professor'),('moliveira','1234','professor'),('mpimenta','1234','professor'),('psantos','1234','aluno'),('rzanella','1234','aluno'),('scechin','1234','professor'),('tsweber','1234','professor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-13 20:28:54
