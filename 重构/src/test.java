import java.util.*;

public class test {
	public static void main(String[] args) {
			Customer customer = new Customer("kunkun"); 
			Customer customer1 = new Customer("huijiadeyouhuo");
			customer.addRental(new Rental(new Movie("��",Movie.REGULAR),1)); 
			customer.addRental(new Rental(new Movie("��",Movie.NEW_RELEASE),1)); 
			customer.addRental(new Rental(new Movie("rep",Movie.CHILDRENS),1)); 
			customer1.addRental(new Rental(new Movie("����",Movie.REGULAR),2));
			customer1.addRental(new Rental(new Movie("Ʒ��",Movie.NEW_RELEASE),2));
			customer1.addRental(new Rental(new Movie("����",Movie.CHILDRENS),2));
			System.out.println(customer.statement());
			System.out.println(customer1.statement());
		
		
	}

}

//Movieֻ��һ-���򵥵Ĵ������ࡣ
class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}
}

//Rental()Rental��ʾĳ���˿�����һ��ӰƬ
class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
}

//Customer (�˿�)
//Customer��������ʾ�˿͡�����������һ��,��Ҳӵ�����ݺ���Ӧ�ķ��ʺ���:
class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
//add frequent renter points
			frequentRenterPoints++;
//add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
//add footer lines
		result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
		return result;
	}
}