# Instructions  

1. Implement a library management system using composition relationships. Create the following classes:</br>

A Book class with:</br>

Private instance variables for title, author, and ISBN (all strings)</br>
A constructor that initializes all fields</br>
Appropriate getter methods</br>


A Library class that:</br>

Has a composition relationship with Book (a library has books)</br>
Stores a collection of books using an array or ArrayList</br>
Has methods to:</br>

Add a book to the library (addBook)</br>
Remove a book by ISBN (removeBook)</br>
Search for books by title (returning all matches) (searchBook, returns an array of books)</br>
Display all books in the library (displayBooks, returns an array of books)</br>

2. Create a smartphone system with clearly defined components using composition. Implement the following classes exactly as specified:</br>

Create a Battery class with:</br>

Private instance variables: int capacityMAh and boolean isCharged (initialized to false)</br>
Constructor: public Battery(int capacityMAh)</br>
Methods:</br>

charge() - Sets isCharged to true</br>
isCharged() - Returns the charge status</br>
getCapacityMAh() - Returns the capacity</br>
toString() - Returns a string representation: "Battery: [capacityMAh] mAh, Charged: [isCharged]"</br>




Create a Display class with:</br>

Private instance variables: double sizeInches and String resolution</br>
Constructor: public Display(double sizeInches, String resolution)</br>
Methods:</br>

turnOn() - return the string "Display turned on. [sizeInches]-inch, [resolution]"</br>
turnOff() - return the string "Display turned off."</br>
getSizeInches() - Returns the size</br>
getResolution() - Returns the resolution</br>
toString() - Returns a string representation: "Display: [sizeInches] inches, [resolution]"</br>




Create a Processor class with:</br>

Private instance variables: String model and double speedGHz</br>
Constructor: public Processor(String model, double speedGHz)</br>
Methods:</br>

processTask(String task) - returns the string "Processing [task] with [model] at [speedGHz] GHz"</br>
 getModel() - Returns the model</br>
getSpeedGHz() - Returns the speed</br>
toString() - Returns a string representation: "Processor: [model], [speedGHz] GHz"</br>




Create a Smartphone class that:</br>

Has composition relationships with all three components</br>
Private instance variables:</br>

private Battery battery;</br>
private Display display;</br>
private Processor processor;</br>
private String brand;</br>
private String model;</br>


Constructors:</br>

public Smartphone(String brand, String model, Battery battery, Display display, Processor processor)</br>
public Smartphone(String brand, String model, int batteryCapacity, double displaySize, String resolution, String processorModel, double processorSpeed) - This constructor should create the component objects internally</br>


Methods:</br>

powerOn() - If battery is charged, turn on display and return the string "Powering on [brand] [model]", otherwise return the string "Cannot power on: Battery depleted"</br>
powerOff() - Turn off display and return the string "Powering off [brand] [model]"</br>
chargeBattery() - Call the battery's charge method</br>
runApp(String appName) - If powered on (check if display is on), use processor to process the app task and return the string "[appName] running.", otherwise return the string "Phone is off. Cannot run [appName]"</br>
upgradeComponent(Battery newBattery) - Replace the battery component</br>
upgradeComponent(Display newDisplay) - Replace the display component</br>
upgradeComponent(Processor newProcessor) - Replace the processor component</br>
toString() - Returns a string in the exact format:

[brand] [model] Smartphone</br>
[battery.toString()]</br>
[display.toString()]</br>
[processor.toString()]</br>
