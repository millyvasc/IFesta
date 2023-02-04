- I F E S T A

-> Equipe
  Camille Janine Chaves Vasconcelos
  Jean Barbosa Santos
  Josué da Silva Bispo Alves


-> Descrição do sistema
O IFesta é um sistema desenvolvido para a criação e divulgação de eventos no IFBaiano, estimulando assim a participação dos alunos, que muitas vezes não possuem conhecimento sobre esses eventos. A ideia é tornar o processo mais simples e fácil do que o processo atual.
Para utilizar o sistema deve-se, primeiramente, realizar o cadastro inserindo informações como matricula, nome, telefone, email e senha. 
Após o cadastro e login, o usuário terá acesso ao sistema onde poderá visualizar seu perfil, editar informações ou deletar sua conta.
O sistema permitirá que os usuários criem eventos por meio de postagens simples contendo informações como nome, tipo, data, horário etc.  
Os usuários também podem adicionar lembretes aos eventos, editando-os ou excluindo-os quando desejarem


-> IDE utilizada
Eclipse IDE Enterprise Java Developers


-> Link do github 
???


-> Link do vídeo:
https://www.youtube.com/watch?v=2auTaqReHEo


-> Matrícula e senha do Usuário criado ao executar o script do BD:
Matrícula: 2021.1
Senha: 123


- PREPARAÇÃO DO AMBIENTE 

-> Ferramentas:

. JDK (Java Development Kit)
  Versão utilizada: OpenJDK 11 LTS (17.0.5) |  JVM : HotSpot
  Link: https://adoptopenjdk.net
 
. IDE: Eclipse IDE Enterprise Java Developers
  Link: https://www.eclipse.org/downloads/

. Servidor: Apache Tomcat 
  Versão utilizada: Apache Tomcat-10.0.27
  Link: https://tomcat.apache.org/download-80.cgi

. Banco de Dados: MYSQL
  Versão utilizada: mysql-8.0.31.0
  Link: https://www.mysql.com/downloads/

*Observação 1:
   Os arquivos necessários para a preparação do ambiente estarão disponíveis na pasta 'Auxiliar'



-> Passo-a-passo:

1- Instalação do JDK (Caso não tenha)
Visite o link que fornecemos para baixar o JDK. No site, selecionamos a versão OpenJDK 11 LTS e JVM Hotspot. Clique em Download e aguarde até que o arquivo seja baixado. Após o download, execute o arquivo. Os termos do software aparecerão, clique em "Aceitar termos de licença do produto". Nas configurações personalizadas, você deve selecionar "JDK with Hotspot" e, em seguida, selecionar "Enterir feature will be installed on local hard drive". Todos os recursos serão instalados e todas as variáveis de ambiente serão configuradas. Clique em Avançar para concluir a instalação do arquivo.


2- Instalação da IDE Eclipse (Caso não tenha)
No site que disponibilizamos terá a versão atualizada do eclipse, basta clicar em download de acordo com as configurações da sua máquina para baixar o arquivo do eclipse.
Após o download execute o arquivo. Para fazer a execução web você terá que selecionar a segunda opção "Eclipse IDE Enterprise Java Developers", após selecioná-lo você deve clicar em Instalar e em seguida, aceitar os termos da licença.


3- Conectando o Servidor Tomcat (Eclipse)
Pressione Ctrl + 3, procure por "servidor" e selecione a primeira opção 
Na aba "servers", clique no link para criar um novo servidor.
Selecione: Apache> Tomcat v10.0 Server> Next> 
Agora devemos selecionar o diretório de instalação do Tomcat, clique em 'Browse' e selecione a pasta 'apache-tomcat-10.0.27' (Local: ...\Projeto-IFesta\Auxiliar\Tomcat)
Clique em "Finish".
Agora clique duas vezes no servidor, selecione a segunda opção "Use Tomcat installation (takes control of Tomcat installation)" e salve as modificações


4- Instalando o Mysql
.Parte 1(Executável)

Execute o instalador "mysql-installer-web-community-8.0.31.0" (Local: ...\Projeto-IFesta\Auxiliar)

Selecione a opção "Custom" > Next>
Agora vamos selecionar as versões que utilizaremos (As mais atualizadas)
MySQL Servers >  MySQL Server> MySQL Server 8.0.31
Clique na setinha virada para a direita (->)
Applications> MySQL Workbench> MySQL Workbench 8.0
clique na setinha virada para a direita (->)
Clique em "Next" e depois em "Execute", irá iniciar o download do MySQL e do Workbench, espere até que os dois tenham sido baixados

Após o download, next> next>
Agora selecione: "Standalone MySQL Server/Classic MySQL Replication" next > "Development Computer" next> 
No 'método de autenticação' selecione a primeira opção para adicionar uma senha ao MySQL (recomendado) e clique em next 
Defina a senha para o MySQL: "root" 
next> next> execute > finish> next> finish

.Parte 2 (Workbench)
Adicione uma nova conexão com o nome localhost e clique em "ok"
Clique na conexão que acabamos de criar e insira sua senha do MySQL


5- Criando o Banco de Dados (Workbench)
Abra o Script do Banco de Dados "Script - IFesta" (Local: ...\Projeto-IFesta\Documentação)
Execute o script (Caso não consiga copie e cole tudo na aba localhost que acabamos de criar)


6- Importando o Projeto (Eclipse)
File> Open Projects from File System> Directory> Selecione a pasta "ifesta" (Local: ...\Projeto-IFesta)> Finish


7- Configurando os parâmetros de conexão (Eclipse)
Caso já tivesse o MySQL/Workbench e seu usuário/senha do MySQL sejam diferentes das apresentadas nesse documento (usuario: root | senha: root), você terá que editar os arquivos "DAOs" do sistema.
ifesta> src/main/java > model> 
Devem ser editados os arquivos: DAO, DAOEventoAcademico, DAOEventoCultural, DAOEventoSocial e DAOLembreteSocial.

private String url = "jdbc:mysql://127.0.0.1:3306/ifesta?useTimezone=true&serverTimezone=UTC";  -> Porta padrão do MySQL: 3306,caso esteja utilizando outra altere aqui
private String user = "root";
private String password = "root"; -> Coloque sua senha do MySQL (caso não tenha senha deixe esse campo vazio)


8- Executando o sistema (Eclipse)
Após a importação do projeto selecione:
ifesta> scr> main> webapp> login.jsp
execute o login.jsp

Pronto. Bem vindo ao IFesta!

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
