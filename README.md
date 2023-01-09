Object Oriented Development
# TestDrivenDevelopmentProject


TDD used to write appropriate tests and the implementing code to meet the below requirements. This is through  implementing classes which implement the appropriate service interface provided.**


Interface file 1:
* GradeCalculatorService
    * This service requires an implementing class that fulfils the interface contract. The implementing class returns the appropriate String value when a double representing a mark is passed in. They are as follows:
        * “fail” when less than 75.
        * “pass” when greater than or equal to 75 but less than 80.
        * “merit” when greater than or equal to 80 but less than 90.
        * “distinction” when greater than or equal to 90 but less than or equal to 100.
        
Interface file 2
* GroupControllerService
    * This service requires an implementing class that fulfils the interface contract. The implementing class returns objects of the appropriate type and meets the requirements specified below:
        * When asking the service implementation for all trainees, the trainees are read from a DatabaseReader object
        * When removing a trainee by their username, a DatabaseWriter object is called.
        * When adding a trainee through the service implementation, the trainee is passed to a DatabaseWriter object.
        * Testing of method is achieved by means of mock objects. 
