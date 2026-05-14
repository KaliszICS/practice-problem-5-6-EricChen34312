import java.util.ArrayList;

class Book {
	private String title;
	private String author;
	private String ISBN;

	public Book(String title, String author, String ISBN){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}

	public String getTitle(){
		return this.title;
	}

	public String getAuthor(){
		return this.author;
	}

	public String getISBN(){
		return this.ISBN;
	}
}

class Library{
	private ArrayList<Book> books;

	public Library(){
		this.books = new ArrayList<>();
	}

	public void addBook(Book b){
		this.books.add(b);
	}

	public void removeBook(String s){
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getISBN().equals(s)){
				books.remove(i);
				return;
			}
		}

		throw new NullPointerException();
	}

	public Book[] searchBook(String s){
		ArrayList<Book> out = new ArrayList<>();

		for(Book b : books){
			if(b.getTitle().contains(s)){
				out.add(b);
			}
		}

		return out.toArray(new Book[0]);
	}

	public Book[] displayBooks(){
		return books.toArray(new Book[0]);
	}
}

class Battery{
	private int capacityMAh;
	private boolean isCharged;

	public Battery(int capacityMAh){
		this.capacityMAh = capacityMAh;
		this.isCharged = false;
	}

	public void charge(){
		this.isCharged = true;
	}

	public boolean isCharged(){
		return this.isCharged;
	}

	public int getCapacityMAh(){
		return this.capacityMAh;
	}

	@Override
	public String toString(){
		return "Battery: " + Integer.toString(this.capacityMAh) + " mAh, Charged: " + Boolean.toString(this.isCharged);
	}
}

class Display{
	private double sizeInches;
	private String resolution;

	public Display(double sizeInches, String resolution){
		this.sizeInches = sizeInches;
		this.resolution = resolution;
	}

	public String turnOn(){
		return "Display turned on. " + Double.toString(sizeInches) + "-inch, " + this.resolution;
	}

	public String turnOff(){
		return "Display turned off.";
	}

	public double getSizeInches(){
		return this.sizeInches;
	}

	public String getResolution(){
		return this.resolution;
	}

	@Override
	public String toString(){
		return "Display: " + Double.toString(sizeInches) + " inches, " + this.resolution;
	}
}

class Processor{
	private String model;
	private double speedGHz;
	
	public Processor(String model, double speedGHz){
		this.model = model;
		this.speedGHz = speedGHz;
	}

	public String getModel(){
		return this.model;
	}

	public double getSpeedGHz(){
		return this.speedGHz;
	}

	public String processTask(String task){
		return "Processing " + task + " with " + model + " at " + Double.toString(speedGHz) + " GHz";
	}

	@Override
	public String toString(){
		return "Processor: " + model + ", " + Double.toString(speedGHz) + "GHz";
	}

}

class Smartphone{
	private Battery battery;
	private Display display;
	private Processor processor;
	private String brand;
	private String model;

	private boolean onOff = false;

	public Smartphone(String brand, String model, Battery battery, Display display, Processor processor){
		this.brand = brand;
		this.model = model;
		this.battery = battery;
		this.display = display;
		this.processor = processor;
	}

	public Smartphone(String brand, String model, int batteryCapacity, double displaySize, String resolution, String processorModel, double processorSpeed){
		this.brand = brand;
		this.model = model;

		this.battery = new Battery(batteryCapacity);
		this.display = new Display(displaySize, resolution);
		this.processor = new Processor(processorModel, processorSpeed);
	}

	public String powerOn(){
		if(this.battery.isCharged()){
			this.display.turnOn();
			this.onOff = true;
			return "Powering on " + this.brand + " " + this.model;
		}

		return "Cannot power on: Battery depleted";
	}

	public String powerOff(){
		this.display.turnOff();
		this.onOff = false;
		return "Powering off " + this.brand + " " + this.model;
	}

	public void chargeBattery(){
		this.battery.charge();
	}

	public String runApp(String appName){
		if(this.onOff){
			return appName + " running.";
		} else {
			return "Phone is off. Cannot run " + appName;
		}
	}

	public void upgradeComponent(Battery newBattery){
		this.battery = newBattery;
	}

	public void upgradeComponent(Display newDisplay){
		this.display = newDisplay;
	}

	public void upgradeComponent(Processor newProcessor){
		this.processor = newProcessor;
	}

	@Override
	public String toString(){
		return "[" + this.brand + "] [" + this.model + " Smartphone [" + battery.toString() + "] [" + display.toString() + "] [" + processor.toString() + "]"; 
	}
}
