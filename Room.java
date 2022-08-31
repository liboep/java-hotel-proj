//Class Person

/*class Person
{
public:
    char *name[40];

};
*/

public class Room
{
	public String name = new String(new char[40]);
	public byte type;
	public int roomNumber;
	public int rent;
	public int min_days;
	public int min_people;
	public int status;
	//class Person cust;
	public final Room addRoom(int rno)
	{
		Room room = new Room();
		room.roomNumber = rno;
		System.out.print("\nRoom type (A/B/C): ");
		cin >> room.type;
		if (room.type == 'c' || room.type == 'C')
		{
			System.out.print("\nEnter minimum days: ");
			cin >> room.min_days;
			System.out.print("\nEnter minimum people: ");
			cin >> room.min_people;
		}
		else
		{
			room.min_days = 0;
			room.min_people = 0;
		}
		System.out.print("\nRent: ");
		cin >> room.rent;
		room.status = 0;
		return room;
	}
	public final void searchRoom(int rno)
	{
		int i;
		int found = 0;
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
			System.out.print("Room Details\n");
			if (GlobalMembersMain.rooms[i].status == 1)
			{
				System.out.print("\nRoom is Reserved");
			}
			else
			{
				System.out.print("\nRoom is available");
			}
//C++ TO JAVA CONVERTER WARNING: The following line was determined to be a copy constructor call - this should be verified and a copy constructor should be created if it does not yet exist:
//ORIGINAL LINE: displayRoom(rooms[i]);
			displayRoom(new Room(GlobalMembersMain.rooms[i]));
			getch();
		}
		else
		{
			System.out.print("\nRoom not found");
			getch();
		}
	}
//	void deleteRoom(int NamelessParameter);Tangible Method Implementation Not FoundRoom-deleteRoom
	public final void displayRoom(Room tempRoom)
	{
		System.out.print("\nRoom Number:\t");
		System.out.print(tempRoom.roomNumber);
		System.out.print("\nRoom type (A/B/C): ");
		System.out.print(tempRoom.type);
		System.out.print("\nRent: ");
		System.out.print(tempRoom.rent);
	}
}