package casim.utils.grid;

import casim.utils.coordinate.Coordinates2D;

/**
 * Bidimensional grid interface.
 * 
 * @param <T> the type of data contained in {@link Grid2D}. 
 */
public interface Grid2D <T> extends Grid<Coordinates2D<Integer>, T>{
	/**
	 * Return the value at given coordinates.
     * 
     * Throws {@link IndexOutOfBoundsException} if the coordinates are out of bound.
	 * 
	 * @param row of the element to get.
	 * @param column of the element to get.
	 * @return the value to at coord.  
	 */
	T get(int row, int column);
	
	/**
	 * Set an element to a given value.
     * 
     * Throws {@link IndexOutOfBoundsException} if the coordinates are out of bound.
	 * 
	 * @param row of the element to set.
	 * @param column of the element to set.
	 * @param value to set.
	 */
	void set(int row, int column, T value);
}
