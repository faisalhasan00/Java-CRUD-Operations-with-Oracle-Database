package Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUD_OPERATION {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String uname ="system";
		String pswd = "root";
		String createQuery ="INSERT INTO PRODUCT VALUES(?,?,?,?)";
		String displayQuery = "SELECT * FROM PRODUCT";
		String displayQuery1 ="SELECT * FROM PRODUCT WHERE PCODE=?";
		String updateQuery ="UPDATE PRODUCT SET PRICE= ? , QTY=QTY+? WHERE PCODE=?";
		String deleteQuery ="DELETE FROM PRODUCT WHERE PCODE = ? ";
		
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,uname,pswd);
			
			PreparedStatement ps1 = con.prepareStatement(createQuery);
			PreparedStatement ps2 = con.prepareStatement(displayQuery1);
			PreparedStatement ps3 = con.prepareStatement(updateQuery);
			PreparedStatement ps4 = con.prepareStatement(displayQuery);
			PreparedStatement ps5 = con.prepareStatement(deleteQuery);
			
			
			
			while(true) {
				System.out.println("====chose====");
				System.out.println("1 ADD\n2 DISPLAY \n3 UPDATE \n4 DLETE");
				System.out.println("Enter your choice:");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1: 
					
					System.out.println("Enter book code:");
					String bcode = sc.nextLine();	
					System.out.println("Enter your Book Name:");
					String bname = sc.nextLine();
					System.out.println("Enter youe book price");
					double price = Double.parseDouble(sc.nextLine());
					System.out.println("Enter Book Qunatity");
					int bqty = Integer.parseInt(sc.nextLine());
					
					ps1.setString(1, bcode);
					ps1.setString(2, bname);
					ps1.setDouble(3, price);
					ps1.setInt(4, bqty);
					
					int k = ps1.executeUpdate();
					if(k>0) {
						System.out.println("Data inserted Successfull...");
					}else {
						System.out.println("Inavlid query");
						
					}
					
					break;
					
				case 2:
					
					System.out.println("PCODE         \tPName           \tPRICE    \tQUANTITY");
					System.out.println("========= \t================= \t========= \t=========");
					ResultSet rs1 = ps4.executeQuery();
					if(!rs1.next()) {
						System.err.println("Product is not available in database");
					}
					else {
//					while(rs1.next()) {
						do {
							System.out.printf("%-12s \t%-17s \t%-8.2f \t%-8.2f%n",
                                    rs1.getString(1),   
                                    rs1.getString(2),   
                                    rs1.getDouble(3),   
                                    rs1.getDouble(4));  
						}
						while(rs1.next());
					
					}
//					}	
					break;
				case 3:
					
					System.out.println("Enter product code: ");
					String pcode = sc.nextLine();
					ps2.setString(1, pcode);
					ResultSet rs = ps2.executeQuery();
					
					if(rs.next()) {
						System.out.println("old Price " +rs.getDouble(3));
						System.out.println("Enter new price:");
						
						double newprice = Double.parseDouble(sc.nextLine());
						System.out.println("Availbale Quantity " + rs.getDouble(4));
						
						System.out.println("Enter new Quantity:");
						int newQnty = Integer.parseInt(sc.nextLine());
						
						ps3.setDouble(1, newprice);
						ps3.setDouble(2, newQnty);
						ps3.setString(3, pcode);
						int ks = ps3.executeUpdate();
						if(ks>0) {
							System.out.println("Updated Successfull...s");
						}
						else {
							System.err.println("Wrong Query");
						}
					}
					else {
						System.err.println("Invalide product code");
					}
					break;
				case 4:
					
					System.out.println("Enter Book code");
					String delProduct = sc.nextLine();
					
					ps5.setString(1, delProduct);
					
					int k2 = ps5.executeUpdate();
					if(k2>0) {
						System.out.println("Product with code '" + delProduct + "' deleted successfully.");
					}
					else {
						System.err.println("Product code '" + delProduct + "' not found in the records.");
					}
					break;
				
				default:
					
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				

	}

}
