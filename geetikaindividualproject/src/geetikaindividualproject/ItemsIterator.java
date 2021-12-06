package geetikaindividualproject;

public class ItemsIterator implements IteratorInt {
	private StaticDB db = StaticDB.getInstance();
	int index =0;
	public boolean hasNext()
	{
		if(index < db.getCreditCards().size())
		{
			return true;
		}
		return false;
	}
	
	public Object next()
	{
		String[] cardsArray = db.getCreditCards().toArray(new String[db.getCreditCards().size()]);
		if(this.hasNext())
		{
			return cardsArray[index++];
		}
		return null;
	}
}
