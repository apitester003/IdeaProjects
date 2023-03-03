package Tutorial.Tut_Collections;

public class Laptop extends Computer {
	private String manufacturer;
	
    public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
    public void start() {
        System.out.println("Laptop started");
    }

    @Override
    public void showInfo() {
        System.out.println("Laptop showInfo() method called");
    }

    public < E > void genericMethod(E[] inputArray){
        for (E element : inputArray){
            System.out.println("Here is the element: " + element);
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		return true;
	}
    
    
}