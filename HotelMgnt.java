
public class HotelMgnt extends Room
{

	//hotel management reservation of room
	public final void reserveRoom()
	{
		int i;
		int found = 0;
		int rno;

		Room room = new Room();
		System.out.print("\nEnter Room number: ");
		cin >> rno;
		for (i = 0; i < GlobalMembersMain.count; i++)
		{
			if (GlobalMembersMain.rooms[i].roomNumber == rno)
			{
				found = 1;
				break;
			}
		}
		if (found == 1)
		{
			if (GlobalMembersMain.rooms[i].status == 1)
			{
				System.out.print("\nRoom is already Reserved");
				return;
			}
			System.out.print("\nEnter Name: ");
			cin >> GlobalMembersMain.rooms[i].name;
			GlobalMembersMain.rooms[i].status = 1;
		}
		else
		{
			System.out.print("\nWTF is going on????");
		}
	}

	//hotel management shows available rooms
	public final void getAvailRoom()
	{
		int i;
		int found = 0;
		for (i = 0; i < GlobalMembersMain.count; i++)
		{
			if (GlobalMembersMain.rooms[i].status == 0)
			{
//C++ TO JAVA CONVERTER WARNING: The following line was determined to be a copy constructor call - this should be verified and a copy constructor should be created if it does not yet exist:
//ORIGINAL LINE: displayRoom(rooms[i]);
				displayRoom(new Room(GlobalMembersMain.rooms[i]));
				System.out.print("\nPress enter for next room");
				found = 1;
				getch();
			}
		}
		if (found == 0)
		{
			System.out.print("\nAll rooms are reserved");
			getch();
		}
	}

	//hotel management shows all persons that booked a room
	public final void cancel_reservation(int roomNum)
	{
		int i;
		int found = 0;
		for (i = 0; i < GlobalMembersMain.count; i++)
		{
			if (GlobalMembersMain.rooms[i].status == 1 && GlobalMembersMain.rooms[i].roomNumber == roomNum)
			{

				System.out.print("\nRoom Number: ");
				System.out.print(GlobalMembersMain.rooms[i].roomNumber);
				System.out.print("\nName: ");
				System.out.print(GlobalMembersMain.rooms[i].name);
				found = 1;
				getch();
				break;
			}
		}
		if (found = 1)
		{
			GlobalMembersMain.rooms[i].roomNumber = 0;
			GlobalMembersMain.rooms[i].name = tangible.StringFunctions.changeCharacter(GlobalMembersMain.rooms[i].name, 40, ' ');

		}
	}

	//hotel managemt generates the bill of the expenses
	public final void generateBill(int roomNum)
	{
		int i;
		int found = 0;
		int days;
		int rno;
		int people;
		float billAmount = 0.0F;
		for (i = 0; i < GlobalMembersMain.count; i++)
		{
			if (GlobalMembersMain.rooms[i].status == 1 && GlobalMembersMain.rooms[i].roomNumber == roomNum)
			{

				System.out.print("\nRoom Number: ");
				System.out.print(GlobalMembersMain.rooms[i].roomNumber);
				System.out.print("\nName: ");
				System.out.print(GlobalMembersMain.rooms[i].name);
				found = 1;
				getch();
				break;
			}
		}
		if (found == 1)
		{
			System.out.print("\nEnter Number of Days: ");
			cin >> days;
			GlobalMembersMain.rooms[i].status = 0;
			if (GlobalMembersMain.rooms[i].type == 'a' || GlobalMembersMain.rooms[i].type == 'A')
			{
				billAmount = days * GlobalMembersMain.rooms[i].rent;
				System.out.print("\nTotal Bill Amount: . ");
				System.out.print(billAmount);
				System.out.print(" $");
			}
			else if (GlobalMembersMain.rooms[i].type == 'b' || GlobalMembersMain.rooms[i].type == 'B')
			{
				float rent_after_disc = GlobalMembersMain.rooms[i].rent;
				int j;
				for (j = 1; j <= days; j++)
				{
					rent_after_disc = rent_after_disc - 10;
					if (rent_after_disc < GlobalMembersMain.rooms[i].rent / 2)
					{
						rent_after_disc = GlobalMembersMain.rooms[i].rent / 2;
					}
					billAmount = billAmount + rent_after_disc;
				}
				System.out.print("\nTotal Bill Amount: . ");
				System.out.print(billAmount);
				System.out.print(" $");
			}
			else
			{
				System.out.print("\nEnter Number of People: ");
				cin >> people;
				if (days < GlobalMembersMain.rooms[i].min_days || people < GlobalMembersMain.rooms[i].min_people)
				{
					System.out.print("\nCan't generate bill because of invalid data!");
				}
				else
				{
					billAmount = days * GlobalMembersMain.rooms[i].rent;
					System.out.print("\nTotal Bill Amount: . ");
					System.out.print(billAmount);
					System.out.print(" $");
				}
			}



		}
		getch();
	}
}
