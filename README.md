# PaymentSystem
Rest Services to initiate transfer
The Application is about the Transfer service. Using the service user can initiate a transfer from on eaccount to another account.
By default there are 4 records in the database. The database will be storing only the account number,name and balance as the accound information.
<br/><br/>
There are two types of REST micro services provided. <br/><br/>
One is the user can create an account and get account details and the another to transfer funds from one account to another account. <br/>
The database used to store data is in memory H2 database. <br/><br/>
This is a spring boot application user can directly run this locally by building the application on any of the IDE adn downloading all the maven dependencies. <br/><br/>
To run on remote server user can export to jar file and deploy on any of the application server. <br/>
The default port used is 8087<br/><br/>
After starting the server locally you can retrieve all the accounts details by clicking the URL:<br/><br/>
http://localhost:8087/allaccounts


