# bringg
1.  Running the challenge :

1.  The assignment is running, by default, on Chrome driver Windows execute file.
     If you want to keep running on windows, just change the property value  webdriver.chrome.driver.path.windows property in application.property file.
     If you want to run the assignment on Linux 32 bit or 64 bit follow these steps : 

      a)  Download the driver executable and add to the property file.
      
      b)  Add the driver path to the property file:

       see at : prop-choose-machine.png
       
       c)  Change in the test class the machine in SeleniumDriver.OS enum (the source code is dynamic, and will recognize the change and update)

       see at : code-choose-machine.png


       d)  Run maven clan from the IDE
       e)   Run maven install (this will run he the tests)
       
       3.  Technologies :-

       a.   Java 8
       b.   Selenium WebDriverManager
       c.   Maven
       d.   Junit 4
       e.   Log4j

4.  Source code :

   Design Patterns  
  
   a.  Decorator (On selenium driver)
   b.  Factory (On selenium page)
   c.  Singletons 
   d.  Factory Method 
   e.  Page Object

   Advanced Java / Automation features :

   a.  Interface default methods (Java 8)
   c.  Is in page verification
   d.  Semi complex generics expression
   e.  Reflection


