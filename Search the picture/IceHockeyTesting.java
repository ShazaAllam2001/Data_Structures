package eg.edu.alexu.datastructure.iceHockey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.Point;

class IceHockeyTesting {

	@Test
	public void test1() {
		IceHockey obj1 = new IceHockey();
		assertArrayEquals(null, obj1.findPlayers(null, 2, 10));
	}
	
	@Test
	public void test2() {
		IceHockey obj2 = new IceHockey();
		String[] image2 = {"33JUBU33",
				           "3U3O4433",
				           "O33P44NB",
				           "PO3NSDP3",
				           "VNDSD333",
				           "OINFD33X"};
		Point [] test2 = new Point[10000];
		test2[0] = new Point(4,5);
		test2[1] = new Point(13,9);
		test2[2] = new Point(14,2);
		assertArrayEquals(test2, obj2.findPlayers(image2, 3, 16));
	}
	
	@Test
	public void test3() {
		IceHockey obj3 = new IceHockey();
		String[] image3 = {"44444H44S4",
				           "K444K4L444",
				           "4LJ44T44XH",
				           "444O4VIF44",
				           "44C4D4U444",
				           "4V4Y4KB4M4",
				           "G4W4HP4O4W",
				           "4444ZDQ4S4",
				           "4BR4Y4A444",
				           "4G4V4T4444"};
		Point [] test3 = new Point[10000];
		test3[0] = new Point(3,8);
		test3[1] = new Point(4,16);
		test3[2] = new Point(5,4);
		test3[3] = new Point(16,3);
		test3[4] = new Point(16,17);
		test3[5] = new Point(17,9);
		assertArrayEquals(test3, obj3.findPlayers(image3, 4, 16));
	}
	
	@Test
	public void test4() {
		IceHockey obj4 = new IceHockey();
		String[] image4 = {"8D88888J8L8E888",
                          "88NKMG8N8E8JI88",
                          "888NS8EU88HN8EO",
			              "LUQ888A8TH8OIH8",
	                      "888QJ88R8SG88TY",
		                  "88ZQV88B88OUZ8O",
			              "FQ88WF8Q8GG88B8",
			              "8S888HGSB8FT8S8",
			              "8MX88D88888T8K8",
			              "8S8A88MGVDG8XK8",
		                  "M88S8B8I8M88J8N", 
		                  "8W88X88ZT8KA8I8",
		       	          "88SQGB8I8J88W88",
		      	          "U88H8NI8CZB88B8",
		      	          "8PK8H8T8888TQR8"};
		Point [] test4 = new Point[10000];
		test4[0] = new Point(1,17);
		test4[1] = new Point(3,3);
		test4[2] = new Point(3,10);
		test4[3] = new Point(3,25);
		test4[4] = new Point(5,21);
		test4[5] = new Point(8,17);
		test4[6] = new Point(9,2);
		test4[7] = new Point(10,9);
		test4[8] = new Point(12,23);
		test4[9] = new Point(17,16);
		test4[10] = new Point(18,3);
		test4[11] = new Point(18,11);
		test4[12] = new Point(18,28);
		test4[13] = new Point(22,20);
		test4[14] = new Point(23,26);
		test4[15] = new Point(24,15);
		test4[16] = new Point(27,2);
		test4[17] = new Point(28,26);
		test4[18] = new Point(29,16);
		assertArrayEquals(test4, obj4.findPlayers(image4, 8, 9));
	}
	
	@Test
	public void test5() {
		IceHockey obj5 = new IceHockey();
		String[] image5 = {"11111",
				           "1AAA1",
				           "1A1A1",
				           "1AAA1",
				           "11111"};
		Point [] test5 = new Point[10000];
		test5[0] = new Point(5,5);
		test5[1] = new Point(5,5);
		assertArrayEquals(test5, obj5.findPlayers(image5, 1, 3));
	}

}
