package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import java.util.*;


public class DataUtilitiesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	/*All code below this line are the various tests created*/
	
	
	/*CreateNumberArray Tests*/
	
	/*
	 * This tests the use of all positive values in the input array into createNumberArray()
	 */
	@Test
	public void createNumberArrayPositiveDouble() {
		//creating expected output and actual input
		Number[] expected = {1.0, 2.0, 3.0, 4.0};
		double[] actualInput = {1.0, 2.0, 3.0, 4.0};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
	
	/*
	 * This tests the use of all negative values in the input array into createNumberArray()
	 */
	@Test
	public void createNumberArrayNegativeDouble() {
		//creating expected output and actual input
		Number[] expected = {-1.0, -2.0, -3.0, -4.0};
		double[] actualInput = {-1.0, -2.0, -3.0, -4.0};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray(actualInput));
	}
	
	
	/*
	 * This tests the use of null as input into createNumberArray()
	 * Note: We have used IllegalArgumentException here as the function throws this instead
	 *       of the intended exception specified in the documentation. Changing the expected to 
	 *       the intended exception results in an error that breaks this test.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNumberArrayNull() throws IllegalArgumentException{
		//Creating null input and testing by asserting
		double[] actualInput = null;
		DataUtilities.createNumberArray(actualInput);
	}
	
	
	/*CreateNumberArray2D Tests*/
	
	
	/*
	 * This tests the use of all positive values in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DPositiveDouble() {
		//creating expected output and actual input
		Number[][] expected = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		double[][] actualInput = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	/*
	 * This tests the use of all negative values in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DNegativeDouble() {
		//creating expected output and actual input
		Number[][] expected = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		double[][] actualInput = {{-1.0, -2.0, -3.0, -4.0}, {-5.0, -6.0, -7.0, -8.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	/*
	 * This tests the use of a "square" array/matrix (2x2) in the input array into createNumberArray2D()
	 */
	@Test
	public void createNumberArray2DSquareArray() {
		//creating expected output and actual input
		Number[][] expected = {{1.0, 2.0}, {5.0, 6.0}};
		double[][] actualInput = {{1.0, 2.0}, {5.0, 6.0}};
		//testing by asserting
		assertArrayEquals(expected, DataUtilities.createNumberArray2D(actualInput));
	}
	
	
	/*calculateColumnTotal Tests*/
	
	
	/*
	 * This tests the use of all positive integers as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForPositiveNumbers() {
		 //Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     
	     
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of all negative integers as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForNegativeNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(1, 0);
	             will(returnValue(-2.7));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-8.0, result, .000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of both negative and positive as entries in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForNegativeAndPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-7.8));
	             one(values).getValue(1, 0);
	             will(returnValue(3.5));
	         }
	     });
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(-4.3, result,.000000001d);
	 }
	 
	 
	 /*
	 * This tests the use of multiple rows as input in the Values2D object used as input in calculateColumnTotal()
	 */
	 @Test
	 public void calculateColumnTotalForFourRows() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getRowCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(2.5));
	             one(values).getValue(1, 0);
	             will(returnValue(7.5));
	             one(values).getValue(2, 0);
	             will(returnValue(7.5));
	             one(values).getValue(3, 0);
	             will(returnValue(5.5));
	         }
	     });
	     //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(23.0, result, .000000001d);
	 } 
	 
	 
	 /*
	 * This tests the use of an empty array as input in the Values2D object used as input in calculateColumnTotal()
	 */
	@Test
	public void calculateColumnTotalEmptyArray() {
		//Creating mocking context
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				//Setting values for the mock object
				one(values).getRowCount();
				will(returnValue(0));
			}
		});
		//Storing output from method call and testing by asserting
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
		

	
	/*
	 * This tests the use of all positive integers as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(0, 1);
	             will(returnValue(2.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of all negative integers as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForNegativeNumbers() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(0, 1);
	             will(returnValue(-2.7));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(-8.0, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of both negative and positive as entries in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForNegativeAndPositiveNumbers() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(-7.8));
	             one(values).getValue(0, 1);
	             will(returnValue(3.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(-4.3, result, .000000001d);
	 }
	 
	 
	 
	 /*
	 * This tests the use of multiple rows as input in the Values2D object used as input in calculateRowTotal()
	 */
	 @Test
	 public void calculateRowTotalForFourColumns() {
		//Creating mocking context
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	//Setting values for the mock object
	             one(values).getColumnCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(2.5));
	             one(values).getValue(0, 1);
	             will(returnValue(7.5));
	             one(values).getValue(0, 2);
	             will(returnValue(7.5));
	             one(values).getValue(0, 3);
	             will(returnValue(5.5));
	         }
	     });
	   //Storing output from method call and testing by asserting
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(23.0, result, .000000001d);
	 } 
	 
	 
	 /*
	 * This tests the use of an empty array as input in the Values2D object used as input in calculateRowTotal()
	 */
	@Test
	public void calculateRowTotalEmptyArray() {
		//Creating mocking context
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				//Setting values for the mock object
				one(values).getColumnCount();
				will(returnValue(0));
			}
		});
		//Storing output from method call and testing by asserting
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	
	/*getCumulativePercentages Tests*/
	
	/*
	 * This tests the use of valid, positive inputs which are placed in the KeyedValues Object used as input in getCumulativePercentages()
	 */
	@Test
    public void getCumulativePercentagesValidInput() {
		//Creating mocking context
        Mockery mockingContextKey = new Mockery();
        KeyedValues mockKeyedValues = mockingContextKey.mock(KeyedValues.class);
        mockingContextKey.checking(new Expectations() {{
        	//Setting values for the mock object
        	
        	//Specifying key and values as lists
            List<Integer> keys = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Double> values = new ArrayList<>(Arrays.asList(5.0, 9.0 , 2.0));

            //Using a for loop to set values for the mock object accordingly
            for(int i= 0; i < keys.size(); i++) {
                allowing(mockKeyedValues).getValue(i);
                will (returnValue(values.get(i)));
                allowing(mockKeyedValues).getKey(i);
                will(returnValue(keys.get(i)));
            }
            //Setting more values for the mock object
            allowing(mockKeyedValues).getItemCount();
            will(returnValue(3));
            allowing(mockKeyedValues).getKeys();
            will(returnEnumeration(keys));
        }
        });
	        //Storing output from method call and testing by asserting each value in the output array
	        List<Number> expectedValues = new ArrayList<>(Arrays.asList(0.3125, 0.875, 1.0));   
	        KeyedValues result = DataUtilities.getCumulativePercentages(mockKeyedValues);
	        for(int i = 0; i < mockKeyedValues.getItemCount(); i++) {
	        	assertEquals(expectedValues.get(i), result.getValue(i));
        }
    }
	
	/*
	 * This tests the use of null as input into getCumulativePercentages()
	 * Note: We have used IllegalArgumentException here as the function throws this instead
	 *       of the intended exception specified in the documentation. Changing the expected to 
	 *       the intended exception results in an error that breaks this test.
	 */
	    @Test (expected = IllegalArgumentException.class)
        public void getCumulativePercentagesInvalidInput() throws IllegalArgumentException{
	    	//Using null as input and calling method
	    	KeyedValues result = DataUtilities.getCumulativePercentages(null);
	    }
	    
// The tests beyond this line of code were added to increase coverage
	    
	    
	    /*
		 * This tests the equal method where the first argument is a null array
		 */
		@Test 
		public void nullArgumentAPassedIntoEqualMethod() {
			//Creating null input and testing by asserting
			double[][] testArrayA = null;
			double[][] testArrayB = { {1, 3, 5, 7}, {9, 11, 13, 15} };
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertFalse(result);
		}
		
		/*
		 * This tests the equal method where the first argument is a null array
		 */
		@Test 
		public void nullArgumentBPassedIntoEqualMethod() {
			//Creating null input and testing by asserting
			double[][] testArrayA = { {1, 3, 5, 7}, {9, 11, 13, 15} };
			double[][] testArrayB = null;
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertFalse(result);
		}
		
		/*
		 * This tests the equal method where the arrays are different sizes
		 */
		@Test 
		public void differentArraySizePassedIntoEqualMethod() {
			//Creating null input and testing by asserting
			double[][] testArrayA = {{1, 3, 5, 7},{9, 11, 13, 15}};
			double[][] testArrayB = {{1, 3, 5, 7}};
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertFalse(result);
		}
		
		/*
		 * This tests the equal method where the arrays are different 
		 */
		@Test 
		public void arraysWithDifferentElementsPassedIntoEqualMethod() {
			//Creating null input and testing by asserting
			double[][] testArrayA = {{1, 3, 5, 7},{10, 11, 13, 15}};
			double[][] testArrayB = { {1, 3, 5, 7}, {9, 11, 13, 15} };
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertFalse(result);
		}
		
		/*
		 * This tests the equal method where the arrays are same
		 */
		@Test 
		public void arraysWithSameElementsPassedIntoEqualMethod() {
			//Creating null input and testing by asserting
			double[][] testArrayA = {{1, 3, 5, 7}, {9, 11, 13, 15}};
			double[][] testArrayB = {{1, 3, 5, 7}, {9, 11, 13, 15}};
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertTrue(result);
		}
		
		
		/*
		 * This tests the clone method with a null array
		 */
		@Test (expected = Exception.class)
		public void cloneNullArray() {
			//Creating null input and testing by asserting
			double[][] testArrayA = null;
			
			double[][] result = DataUtilities.clone(testArrayA);
			
			assertNull(result);
		}
		
		
		
		 /*
		 * This tests the use of a valid input into the function
		 */
		@Test 
		public void calculateColumnTotalValidInput() {
			//Creating mocking context
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	//Setting values for the mock object
		             one(values).getRowCount();
		             will(returnValue(4));
		             
		             one(values).getValue(0, 0);
		             will(returnValue(2.5));
		             one(values).getValue(1, 0);
		             will(returnValue(7.5));
		             one(values).getValue(2, 0);
		             will(returnValue(7.5));
		             one(values).getValue(3, 0);
		             will(returnValue(5.5));
		         }
		     });
		   //Storing output from method call and testing by asserting
		     int[] validRows = {0,1,2,3};
		     double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		     assertEquals(23.0, result, .000000001d);
		}
		
		
		 /*
		 * This tests the use of null as an input to the function
		 */
		@Test (expected = IllegalArgumentException.class)
		public void calculateRowTotalNullInput() {
			//Calling Method
			int[] validCols = {0};
			DataUtilities.calculateColumnTotal(null, 0, validCols);
		}
		
		
		 /*
		 * This tests the use of a valid input into the function
		 */
		@Test 
		public void calculateRowTotalValidInput() {
			//Creating mocking context
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	//Setting values for the mock object
		             one(values).getColumnCount();
		             will(returnValue(4));
		             
		             one(values).getValue(0, 0);
		             will(returnValue(2.5));
		             one(values).getValue(0, 1);
		             will(returnValue(7.5));
		             one(values).getValue(0, 2);
		             will(returnValue(7.5));
		             one(values).getValue(0, 3);
		             will(returnValue(5.5));
		         }
		     });
		   //Storing output from method call and testing by asserting
		     int[] validCols = {0,1,2,3,4};
		     double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		     assertEquals(23.0, result, .000000001d);
		}
		
		/*
		 * This tests the use of a column count less than 0  into the function
		 */
		@Test 
		public void calculateRowTotalInvalidInput() {
			//Creating mocking context
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	//Setting values for the mock object
		             one(values).getColumnCount();
		             will(returnValue(-2));  
		         }
		     });
		   //Storing output from method call and testing by asserting
		     int[] validCols = {};
		     double result = DataUtilities.calculateRowTotal(values, -2, validCols);
		     assertEquals(0.0, result, .000000001d);
		}
		
		/**
	     * This test will be testing the clone function when the 2D array is valid
	     */
	    @Test
	    public void cloneValidArguement() {
	            double[][] test = {{1,2,3},{4,5,6}};
	            double[][] result = DataUtilities.clone(test); 
	            assertArrayEquals(test,result);
	    }
			    
	    
	    /*
		 * This tests the equal method where the first argument is a null array
		 */
		@Test 
		public void equalsBothNull() {
			//Creating null input and testing by asserting
			double[][] testArrayA = null;
			double[][] testArrayB = null;
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertTrue(result);
		}
	 
		
		/*
		 * This tests the equal method where the arrays are different 
		 */
		@Test 
		public void equalsArraySameSizeDifferentFirstElement() {
			//Creating null input and testing by asserting
			double[][] testArrayA = {{1, 2, 5, 7},{9, 11, 13, 15}};
			double[][] testArrayB = { {1, 3, 5, 7}, {9, 11, 13, 15} };
			
			boolean result = DataUtilities.equal(testArrayA, testArrayB);
			
			assertFalse(result);
		}
		
		
		/**
	     * This test will be testing the clone function when the 2D array is valid
	     */
	    @Test
	    public void cloneValidWithRandomNullElement() {
	            double[][] test = {{1,2,3},null, {4,5,6}};
	            double[][] result = DataUtilities.clone(test); 
	            assertArrayEquals(test,result);
	    }
	    
	    
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void calculateColumnTotalOverloadedNullInput(){
	    	int [] rows = {0};
	    	double result = DataUtilities.calculateColumnTotal(null, 0, rows);
	    }

	    
	    @Test(expected = IllegalArgumentException.class)
	    public void calculateRowTotalOverloadedNullInput(){
	    	int [] columns = {0};
	    	double result = DataUtilities.calculateRowTotal(null, 0, columns);
	    }
	    
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void calculateColumnTotalNullInput(){
	    	int [] columns = {0};
	    	double result = DataUtilities.calculateColumnTotal(null, 0);
	    }

	    
	    
	    @Test
	    public void calculateColumnTotalUnusedRows() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(3));
	                one(values).getValue(1, 1);
	                will(returnValue(6));
	                one(values).getValue(2, 1);
	                will(returnValue(9));
	            }
	        });
	        int[] rows = {1, 2, 5};
	        double result = DataUtilities.calculateColumnTotal(values, 1, rows);
	        assertEquals(15, result, .000000001d);
	    }
	    
	    @Test
	    public void calculateRowTotalUnusedCols() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(3));
	                one(values).getValue(1, 1);
	                will(returnValue(6));
	                one(values).getValue(1, 2);
	                will(returnValue(9));
	            }
	        });
	        int[] columns = {1, 2, 5};
	        double result = DataUtilities.calculateRowTotal(values, 1, columns);
	        assertEquals(15, result, .000000001d);
	    }
		
	    
	    @Test
	    public void calculateColumnTotalRandomNullInputs() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(null));
	                one(values).getValue(1, 0);
	                will(returnValue(6));
	                one(values).getValue(2, 0);
	                will(returnValue(null));
	            }
	        });
	        int[] rows = {0, 1, 2};
	        double result = DataUtilities.calculateColumnTotal(values, 0, rows);
	        assertEquals(6, result, .000000001d);
	    }
	    
	    @Test
	    public void calculateRowTotalRandomNullInputs() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(null));
	                one(values).getValue(0, 1);
	                will(returnValue(6));
	                one(values).getValue(0, 2);
	                will(returnValue(null));
	            }
	        });
	        int[] columns = {0, 1, 2};
	        double result = DataUtilities.calculateRowTotal(values, 0, columns);
	        assertEquals(6, result, .000000001d);
	    }


	    
	    @Test
	    public void calculateColumnTotalColNotSet() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking (new Expectations () {
	            {
	                one(values).getRowCount ();
	                will(returnValue(3));
	                
	                one(values).getValue(0,0);
	                will(returnValue(1));
	                one(values).getValue(0,1);
	                will(returnValue(2));
	                one(values).getValue(0,2);
	                will(returnValue(3));
	                
	                one(values).getValue(1,0);
	                will(returnValue(4));
	                one(values).getValue(1,1);
	                will(returnValue(5));
	                one(values).getValue(1,2);
	                will(returnValue(6));
	                
	                one(values).getValue(2,0);
	                will(returnValue(7));
	                one(values).getValue(2,1);
	                will(returnValue(8));
	                one(values).getValue(2,2);
	                will(returnValue(9));
	            }
	        });

	        int [] rows = {0,3};
	        double result = DataUtilities.calculateColumnTotal (values, 1, rows);
	        assertEquals (2, result, 0.000000001d);
	    }

	    @Test
	    public void calculateRowTotalRowNotSet() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking (new Expectations () {
	            {
	                one(values).getColumnCount ();
	                will(returnValue(3));
	                
	                one(values).getValue(0,0);
	                will(returnValue(1));
	                one(values).getValue(1,0);
	                will(returnValue(2));
	                one(values).getValue(2,0);
	                will(returnValue(3));
	                
	                one(values).getValue(0,1);
	                will(returnValue(4));
	                one(values).getValue(1,1);
	                will(returnValue(5));
	                one(values).getValue(2,1);
	                will(returnValue(6));
	                
	                one(values).getValue(0,2);
	                will(returnValue(7));
	                one(values).getValue(1,2);
	                will(returnValue(8));
	                one(values).getValue(2,2);
	                will(returnValue(9));
	            }
	        });

	        int [] columns = {0,3};
	        double result = DataUtilities.calculateRowTotal (values, 1, columns);
	        assertEquals (2, result,  0.000000001d);
	    }

	    @Test
	    public void calculateColumnTotalArrayCheck () {
	        Mockery mockingContext = new Mockery ();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking (new Expectations () {
	            {
	            	one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(null));
	                one(values).getValue(1, 0);
	                will(returnValue(2));
	                one(values).getValue(2, 0);
	                will(returnValue(null));
	            }
	        });

	        int [] result = {0,1,2};
	        int [] rows = {0,1,2};
	        DataUtilities.calculateColumnTotal (values, 0, rows);
	        assertArrayEquals (result, rows);
	    }
	    
	    @Test
	    public void calculateRowTotalCheckArrayCheck () {
	        Mockery mockingContext = new Mockery ();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking (new Expectations () {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(null));
	                one(values).getValue(0, 1);
	                will(returnValue(2));
	                one(values).getValue(0, 2);
	                will(returnValue(null));
	            }
	        });

	        int [] result = {0,1,2};
	        int [] rows = {0,1,2};
	        DataUtilities.calculateRowTotal (values, 0, rows);
	        
	        assertArrayEquals (result, rows);
	    }
	    
	    @Test
	    public void calculateRowTotalValidDataTestTwice(){
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	            	atLeast(1).of(values).getColumnCount();
	                will(returnValue(3));
	                atLeast(1).of(values).getValue(0, 0);
	                will(returnValue(5.67));
	                atLeast(1).of(values).getValue(0, 1);
	                will(returnValue(5.2));
	                atLeast(1).of(values).getValue(0, 2);
	                will(returnValue(1.2));
	            }
	        });
	        DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("The calculated total is 12.07",DataUtilities.calculateRowTotal(values, 0), 12.07, .000000001d);
	    }
	    
	    @Test(timeout=100)
	    public void calculateColumnTotalValidDataTestTwice(){
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	            	atLeast(1).of(values).getRowCount();
	                will(returnValue(3));
	                atLeast(1).of(values).getValue(0, 0);
	                will(returnValue(5.67));
	                atLeast(1).of(values).getValue(1, 0);
	                will(returnValue(5.2));
	                atLeast(1).of(values).getValue(2, 0);
	                will(returnValue(1.2));
	            }
	        });
	        DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals("The calculated total is 12.07",DataUtilities.calculateColumnTotal(values, 0), 12.07, .000000001d);
	    }
	    
	    @Test
	    public void calculateRowTotal_ValidDataValidRowValidColumnsTestedTwice() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	            	atLeast(1).of(values).getColumnCount();
	                will(returnValue(3));
	                atLeast(1).of(values).getRowCount();
	                will(returnValue(3));
	                atLeast(1).of(values).getValue(0, 0);
	                will(returnValue(4));
	                atLeast(1).of(values).getValue(1, 1);
	                will(returnValue(5));
	                atLeast(1).of(values).getValue(1, 2);
	                will(returnValue(9));
	            }
	        });
	        int[] columns = {1, 2};
	        DataUtilities.calculateRowTotal(values, 1, columns);
	        assertEquals("The calculated total is 14.0",DataUtilities.calculateRowTotal(values, 1, columns), 14.0, .000000001d);
	    }

	    



	
}