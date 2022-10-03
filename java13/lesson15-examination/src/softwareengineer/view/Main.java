package softwareengineer.view;

import java.util.List;
import java.util.Scanner;

import softwareengineer.bean.Invoice;
import softwareengineer.bean.Item;
import softwareengineer.bo.InvoiceBoImplement;

public class Main {
	public static void menu() {
		System.out.println("Welcome to Invoice management system ");
		System.out.println("1. Display all invoices in the system");
		System.out.println("2. Add an new invoice");
		System.out.println("3. Delete an invoice with id");
		System.out.println("4. Update an invoice with id (price,quantity)");
		System.out.println("5. Exit");
	}
	private static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		InvoiceBoImplement invoices= new InvoiceBoImplement();
		int choosen;
		while(true) {
			menu();
			System.out.print("Your choosen is :");
			choosen=sc.nextInt();
			switch (choosen) {
			case 1:{
				invoices.displayInvoice();
				break;
			}
			case 2:{
				
				int id= sc.nextInt();
				List<Item> items= List.of(
						new Item(1, "Nuoc", "chai", 10, 2, 0),
						new Item(2, "Bun dau","met", 1, 2, 0)
						);
				double total=0;
				for(Item item:items) {
					total+=item.getPrice()*item.getQuantity();
				}
				invoices.addNewInvoice(new Invoice(id, items,total));
				break;
			}
			case 3:{
				System.out.print("Enter the id of invoice wanna delete: ");
				int id = sc.nextInt();
				invoices.deleteInvoice(id);
				break;
			}
			case 4:{
				System.out.print("Enter the id of invoice wanna update: ");
				int id=sc.nextInt();
				System.out.print("Enter the id of item: ");
				int idItem=sc.nextInt();
				System.out.print("Enter new price: ");
				double price=sc.nextDouble();
				System.out.println("Enter new quantity: ");
				int quantity=sc.nextInt();
				invoices.updateInvoice(id, idItem, price, quantity);
				break;
			}
			case 5:{
				System.exit(0);
			}

			
		}
	}
}
}
