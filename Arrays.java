public final class Arrays
{
	public static Room[] initializeWithDefaultRoomInstances(int length)
	{
		Room[] array = new Room[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new Room();
		}
		return array;
	}
}
