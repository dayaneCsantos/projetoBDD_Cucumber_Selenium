# Teste automatizado

<img src= "https://i.imgur.com/VrU4R2Q.gif">  

​	Os testes automatizados foram desenvolvidos utilizando do BDD (Behavior Driven Development), para documentar os comportamentos esperados, o Cumcuber como suporte para o desenvolvimento orientado a comportamento, abordando testes unitários e funcionais.

## Ferramentas e tecnologias:

* Eclipse IDE for Java Developers 

* Cucumber

* BDD

* Gherkin 

* Selenium WebDriver

* Java

## Como executar em sua máquina: 

* Clone o projeto; 
* Caso não tenha, instale o JDK;
* Utilize uma IDE, utilizado por mim: Eclipse IDE for Java Developers;
* O caminho para execução do teste funcional `src\test\java\br\ce\wcaquino\runners\RunnerFunTest.java` ;
* Caso exista caracteres especias, clique na pasta do projeto com o botão direito, clique em `properties`, em seguida em resource em `text file encoding` altere para UTF-8;
* Caso não tenha, instale o WebDriver for Chrome (versão correta do chrome, caso não faça isso, irá resultar em erro);
* Após baixar o WebDrive para Chrome, adicione o endereço do arquivo no PATH nas variaveis de ambiente, caso necessário adicione como primeira linha do `void` em 
```java 
  RunnerFunTest.java System.setProperty("webdriver.chrome.driver", "\\Users\\Dayane\\Downloads\\chromedriver_win32\\chromedriver.exe")
```
* O caminho para execução do teste unitário é src\test\java\br\ce\wcaquino\runners\RunnerTest.java;
* Agora sim! Só executar.

  

  
