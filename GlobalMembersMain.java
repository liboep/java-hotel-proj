public class GlobalMembersMain
{
	//Global Declarations

	public static Room[] rooms = tangible.Arrays.initializeWithDefaultRoomInstances(DefineConstants.max);
	public static int count = 0;


	//managing rooms (adding and searching available rooms)
	public static void manageRooms()
	{
		Room room = new Room();
		int opt;
		int rno;
		int i;
		int flag = 0;
		byte ch;
		do
		{
			system("cls");
			System.out.print("Hotel Management\n");
			System.out.print("\nManage Room");
			System.out.print("\n1. Add Room");
			System.out.print("\n2. Search Room");
			System.out.print("\n3. Back to Main Menu");
			System.out.print("\nEnter Option: ");
			cin >> opt;


	//switch statement
			switch (opt)
			{
			case 1:
				System.out.print("\nEnter Room Number: ");
				cin >> rno;
				i = 0;
				for (i = 0; i < count; i++)
				{
					if (rooms[i].roomNumber == rno)
					{
						flag = 1;
					}
				}
				if (flag == 1)
				{
					System.out.print("\nRoom Number is Present.\nPlease enter unique Number");
					flag = 0;
					getch();
				}
				else
				{
					rooms[count] = room.addRoom(rno);
					count++;
				}
				break;
			case 2:
				System.out.print("\nEnter room number: ");
				cin >> rno;
				room.searchRoom(rno);
				break;
			case 3:
				//	 cout<<"Do you want to Exit (Y/N:) ";
				//	 cin>>ch;
				break;
			default:
				System.out.print("\nPlease Enter correct option");
				break;
			}
		} while(opt!=3);
	}
	public static int Main()
	{
		HotelMgnt hm = new HotelMgnt();
		int i;
		int j;
		int opt;
		int rno;
		byte ch;
		String pname;
		system("cls");
		do
		{
			system("cls");
			System.out.print("Hotel Management\n");
			System.out.print("\n1. Manage Rooms");
			System.out.print("\n2. Reserve Room");
			System.out.print("\n3. Available Rooms");
			System.out.print("\n4. Cancel Reservation");
			System.out.print("\n5. Generate Bill");
			System.out.print("\n6. Exit");
			System.out.print("\nEnter Option: ");
			cin >> opt;
			switch (opt)
			{
			case 1:
				GlobalMembersMain.manageRooms();
				break;
			case 2:
				if (count == 0)
				{
					System.out.print("\nRooms data is not available.\nPlease add the rooms first.");
					getch();
				}
				else
				{
					hm.reserveRoom();
				}
				break;
			case 3:
				if (count == 0)
				{
					System.out.print("\nRooms data is not available.\nPlease add the rooms first.");
					getch();
				}
				else
				{
					hm.getAvailRoom();
				}
				break;
			case 4:
				if (count == 0)
				{
					System.out.print("\nRooms data is not available.\nPlease add the rooms first.");
					getch();
				}
				else
				{
					System.out.print("Enter Room Number: ");
					cin >> rno;
					hm.cancel_reservation(rno);
				}
				break;
			case 5:
				if (count == 0)
				{
					System.out.print("\nRooms data is not available.\nPlease add the rooms first.");
					getch();
				}
				else
				{
					System.out.print("Enter Room Number: ");
					cin >> rno;
					hm.generateBill(rno);
				}
				break;
			case 6:
				System.out.print("\nTHANK YOU!");
				break;
			default:
				System.out.print("\nPlease Enter correct option");
				break;
			}
		} while(opt!=6);
		getch();
	}
}