package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.Range;

public class RangeTest {
	//Variety of objects used to test the various methods in this class
	Range testRangeObj;
	Range combineObj1;
	Range combineObj2;
	Range shiftObj;

	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//Used to create objects before each test
	@Before
	public void setUp() throws Exception {
		testRangeObj = new Range(-10.0, 10.0);
		combineObj1 = new Range(-20, -10);
		combineObj2 = new Range(10, 20);
		shiftObj = new Range(3, 6);


	}

	//Used to reset all objects after each test
	@After
	public void tearDown() throws Exception {
		testRangeObj = null;
		combineObj1 = null;
		combineObj2 = null;
		shiftObj = null;
	}
	
	
	/*ALL CODE BELOW THIS LINE ARE OUR TESTS*/
	
	
	
	/*contains() tests below*/
	
	/*
	 * This tests a value that exists within the test Range Object
	 */
	@Test
	public void containsWithinBounds() {
		//Testing by asserting
		assertTrue(testRangeObj.contains(1.0));
	}
	
	
	/*
	 * This tests a value that is less than the lower bound of the test Range Object
	 */
	@Test
	public void containsOutOfLowerBound() {
		//Testing by asserting
		
		assertFalse(testRangeObj.contains(-25.0));
	}
	
	
	/*
	 * This tests a value that is greater than the upper bound of the test Range Object
	 */
	@Test
	public void containsOutOfUpperBound() {
		//Testing by asserting
		assertFalse(testRangeObj.contains(25.0));
	}
	
	
	
	/*intersect() tests below*/
	
	
	/*
	 * This tests a range that is encapsulated (within) by the test Range Object
	 */
	@Test 
	public void intersectWithinBoundry() {
		//Testing by asserting
		assertTrue(testRangeObj.intersects(-6.0, 6.0));
	}
	
	
	/*
	 * This tests a range that exactly equal to the range in the test Range Object
	 */
	 @Test
	    public void intersectsSameBoundaries() {
		//Testing by asserting
	        assertTrue(testRangeObj.intersects(-10, 10));
	 }
	 
	
	 /*
	 * This tests a range where the lower bound is out of the Range Object range and the upper bound is within the Range Object range
	 */
	@Test
    public void intersectsLowerOutOfRangeUpperInRange() {
		//Testing by asserting
        assertTrue(testRangeObj.intersects(-15, -5));
    }
    
	
	/*
	 * This tests a range where the upper bound is out of the Range Object range and the lower bound is within the Range Object range
	 */
    @Test
    public void intersectsUpperOutOfRangeLowerInRange() {
    	//Testing by asserting
        assertTrue(testRangeObj.intersects(5, 15));
    }
	
    
    
    /*
	 * This tests a range that is smaller than and is completley out of the test Range Object
	 */
    @Test
    public void intersectsOutOfRangeBelowLower() {
    	//Testing by asserting
    	assertFalse(testRangeObj.intersects(-30, -20));
    }
    
    
    /*
	 * This tests a range that is greater than and is completley out of the test Range Object
	 */
    @Test
    public void intersectsOutOfRangeAboveUpper() {
    	//Testing by asserting
    	assertFalse(testRangeObj.intersects(20, 30));
    }

    
    /*combine() tests below*/
    
    
    /*
	 * This tests uses two valid range objects and calls the combine() method on them
	 */
    @Test 
    public void combineValidInput(){
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(combineObj2, combineObj1);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests uses null for the first input and a valid Range object for the second object when calling combine()
	 */
    @Test
    public void combineFirstRangeNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(null, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(20, result.getUpperBound(), .000000001d);
    }
    
    /*
	 * This tests uses a valid Range object for the first input and null for the second object when calling combine()
	 */
    @Test
    public void combineSecondRangeNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.combine(combineObj1, null);
    	assertEquals(-20, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests uses null for both inputs when calling combine()
	 */
    @Test
    public void combineBothRangesNull() {
    	Range result = Range.combine(null, null);
    	assertEquals(null, result);
    }
    
    
    /*
	 * This tests uses two Range objects as input where both ranges are in the negative region when calling combine()
	 */
    @Test
    public void combineOnlyNegativeRanges() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range test = new Range(-100, -50);
    	Range result = Range.combine(combineObj1, test);
    	assertEquals(-100, result.getLowerBound(), .000000001d);
    	assertEquals(-10, result.getUpperBound(), .000000001d);
    }
    
    /*
	 * This tests uses two Range objects as input where both ranges are in the positive region when calling combine()
	 */
    @Test
    public void combineOnlyPostiveRanges() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range test = new Range(50, 100);
    	Range result = Range.combine(test, combineObj2);
    	assertEquals(10, result.getLowerBound(), .000000001d);
    	assertEquals(100, result.getUpperBound(), .000000001d);
    }
    
	
    /*expandToInclude() tests below*/
    
    
    /*
	 * This tests a case where the input value is greater than the upper bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueAboveUpperBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 15.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(15.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests a case where the input value is less than the lower bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueUnderLowerBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, -15.0);
    	assertEquals(-15.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
	 * This tests a case where the input value is less than the lower bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueWithinRange() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 6.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    
 
    /*
	 * This tests a case where the input value is equal to the upper bound of the test Range object
	 */
    @Test
    public void expandToIncludeValueEqualsUpperBound() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(testRangeObj, 10.0);
    	assertEquals(-10.0, result.getLowerBound(), .000000001d);
    	assertEquals(10.0, result.getUpperBound(), .000000001d);
    }
    


    /*
	 * This tests a case where the input Range Object is null
	 */
    @Test
    public void expandToIncludeRangeIsNull() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.expandToInclude(null, 5.0);
    	assertEquals(5.0, result.getLowerBound(), .000000001d);
    	assertEquals(5.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*shift() tests below*/
    
    
    /*
   	 * This tests a case where the delta value input is a positive value
   	 */
    @Test
    public void shiftDeltaGreaterThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, 5.0);
    	assertEquals(8.0, result.getLowerBound(), .000000001d);
    	assertEquals(11.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value input is a negative value
   	 */
    @Test
    public void shiftDeltaLessThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -2.0);
    	assertEquals(1.0, result.getLowerBound(), .000000001d);
    	assertEquals(4.0, result.getUpperBound(), .000000001d);
    }
    
    
    
    /*
   	 * This tests a case where the delta value causes the input range to cross zero on the lower bound
   	 */
    @Test
    public void shiftLowerBoundCrossZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -4.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(2.0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value causes the input range to cross zero on both upper and lower bound
   	 */
    public void shiftLowerAndUpperBoundCrossZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, -10.0);
    	assertEquals(0, result.getLowerBound(), .000000001d);
    	assertEquals(0, result.getUpperBound(), .000000001d);
    }
    
    
    /*
   	 * This tests a case where the delta value is greater than zero and not a whole number
   	 */
    @Test
    public void shiftDeltaGreaterThanZeroAndNotWhole() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range result = Range.shift(shiftObj, 5.5);
    	assertEquals(8.5, result.getLowerBound(), .000000001d);
    	assertEquals(11.5, result.getUpperBound(), .000000001d);
    }

    // NEW TESTS AFTER THIS LINE OF CODE
    
    /*
   	 * This tests a case where the Range object is created incorrectly with the lower bound being larger than the higher bound
   	 */
    
    @Test (expected = IllegalArgumentException.class)
    public void constructorInvalidCreation() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range test = new Range(5,0);
    }
    
    
    /*
   	 * This tests a case where the shift method is provided a boolean allowing the range to cross zero 
   	 */
    
    @Test
    public void allowingZeroCrossageOnShift() {
    	Range result = Range.shift(shiftObj, -10.0, true);
    	assertEquals(-7.0, result.getLowerBound(), .000000001d);
    	assertEquals(-4.0, result.getUpperBound(), .000000001d);	
    }
   
    
    
    
    /*
   	 * This tests the shiftWithNoZeroCrossing() when provided a value less than 0.0
   	 */
    
    @Test
    public void shiftWithNoZeroCrossingLessThanZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range shiftedWithNoZeroCrossing = new Range(-5.0, 10.0);
    	Range newShiftObj = Range.shift(shiftedWithNoZeroCrossing, 5.0, false);
    	
    	assertEquals(0.0, newShiftObj.getLowerBound(), .000000001d);
    	assertEquals(15.0, newShiftObj.getUpperBound(), .000000001d);
    		
    }
    
    /*
   	 * This tests the shiftWithNoZeroCrossing() when provided a value less than 0.0
   	 */
    @Test
    public void shiftWithNoZeroCrossingEqualToZero() {
    	//Storing result from function call and testing by asserting both bounds of the result
    	Range shiftedWithNoZeroCrossing = new Range(0.0, 10.0);
    	Range newShiftObj = Range.shift(shiftedWithNoZeroCrossing, 5.0, false);
    	
    	assertEquals(5.0, newShiftObj.getLowerBound(), .000000001d);
    	assertEquals(15.0, newShiftObj.getUpperBound(), .000000001d);
    		
    }
    
    
	 
	  /*
      * This test the intersection of a Range being false
      */
	  @Test
	  public void testRangeIntersection() {
	      //Storing result from function call and testing by asserting the return value
	      Range intersectRange = new Range(9.0, 10.0);
	      boolean result = shiftObj.intersects(intersectRange);
	      assertFalse(result);
	      
	  }
	  
	  /*
      * This test the hashcode of a Range being true
      */
	  @Test
	  public void testHashCode() {
		  int result;
	      long temp;
	      temp = Double.doubleToLongBits(testRangeObj.getLowerBound());
	      result = (int) (temp ^ (temp >>> 32));
	      temp = Double.doubleToLongBits(testRangeObj.getUpperBound());
	      result = 29 * result + (int) (temp ^ (temp >>> 32));
	      
	      
	      assertEquals(result, testRangeObj.hashCode());
	  }
	  
	  
	  
	  /*
      * This test is to test the expansion of the upper and lower bound by 50%
      */
	  @Test
	  public void testExpansionOfRangeByFiftyPercent() {
		  
		  Range expandedRange = Range.expand(shiftObj, 0.5, 0.5);
		  
		  
		  assertEquals(1.5, expandedRange.getLowerBound(),.000000001d);
		  assertEquals(7.5, expandedRange.getUpperBound(),.000000001d);
		  
	  }
	  
	  /*
	  * This test is to test the expansion of the upper and lower bound by -50% & -0.75% respectively
	  */
	  
	  @Test
	  public void testExpansionOfRangeByNegativeAmount() {
		  Range expandedRange = Range.expand(shiftObj, -0.5, -0.75);
		 
		  assertEquals(4.125, expandedRange.getLowerBound(),.000000001d);
		  assertEquals(4.125, expandedRange.getUpperBound(),.000000001d);
		  

	  }
	  
	  

	 
	 /*
      * This tests the constrain when the value is not contained in the range being less than the lower bound
      */
	  @Test
	  public void constrainWhereValueisNotContainedLower() {
	      Range test = new Range(0,5);
	      double result = test.constrain(-1);
	      assertEquals(0, result,.000000001d);
      }
	  
	  /*
       * This tests the constrain when the value is not contained in the range being greater than the upper bound
       */
	  @Test
   	  public void constrainWhereValueisNotContainedUpper() {
	       Range test = new Range(0,5);
	       double result = test.constrain(6);
	       assertEquals(5, result,.000000001d);
       }
	  
	  /*
       * This tests the constrain when the value is contained within the range's bounds
       */
	   @Test
	   public void constrainWhereValueisContained() {
	       Range test = new Range(0,5);
	       double result = test.constrain(3);
	       assertEquals(3, result,.000000001d);
       }
	   
	   /*
	    * This tests scale where the factor is less then zero
	    */
	    @Test(expected = IllegalArgumentException.class)
	    public void scaleWhereFactorisLessThenZero() {
         Range result = new Range(2,5);
         result = Range.scale(result, -2);
	    }
	  
         
         /*
    	 * This tests the combineIgnoringNaN method with the first parameter as null and the second as a valid object
    	 */
         @Test
         public void combineIgnoringNaNFirstNullSecondNotNull() {
         	//creating new range object and calling the method in question
     		Range test = new Range(2, 6);
     		Range newRange = Range.combineIgnoringNaN(null, test); 
     		//asserting to ensure correct range is created
     		assertEquals(newRange, test);
         }
         
         /*
    	 * This tests the combineIgnoringNaN method with the first parameter as a valid object and the second as null
    	 */
         @Test
         public void combineIgnoringNaNFirstNotNullSecondNull() {
         	//creating new range object and calling the method in question
     		Range test = new Range(2, 6);
     		Range newRange = Range.combineIgnoringNaN(test, null); 
     		//asserting to ensure correct range is created
     		assertEquals(newRange, test);
         }
         
         /*
        	 * This tests the combineIgnoringNaN method with the first parameter as null and the second as a range object with NaN parameters
        	 */
         @Test
         public void combineIgnoringNaNFirstNullSecondNaN() {
         	//Creating NaN double
     		double NaN = Math.sqrt(-1); 
     		//creating new range object and calling the method in question
     		Range test = new Range(NaN, NaN); 
     		Range newRange = Range.combineIgnoringNaN(null, test);
     		//asserting to ensure correct range is created
     		assertNull(newRange);
         }
         
         
         /*
        	 * This tests the combineIgnoringNaN method with the first parameter as a range object with NaN parameters and the second as null
        	 */
         @Test
         public void combineIgnoringNaNFirstNaNSecondNull() {
         	//Creating NaN double
     		double NaN = Math.sqrt(-1); 
     		//creating new range object and calling the method in question
     		Range test = new Range(NaN, NaN); 
     		Range newRange = Range.combineIgnoringNaN(test, null);
     		//asserting to ensure correct range is created
     		assertNull(newRange);
         }
         
         /*
    	 * This tests the combineIgnoringNaN method with both paramters as null
    	 */
         @Test
         public void combineIgnoringNaNFirstNullSecondNull() {
         	//creating new range object and calling the method in question
     		Range newRange = Range.combineIgnoringNaN(null, null);
     		//asserting to ensure correct range is created
     		assertNull(newRange);
         }
         
         /*
    	 * This tests the combineIgnoringNaN method with both parameters as valid range objects
    	 */
         @Test
         public void combineIgnoringNaNFirstNotNulllSecondNotNull() {
         	//creating new range object and calling the method in question
     		Range test = new Range(2, 6);
     		Range test2 = new Range(4, 7);
     		Range newRange = Range.combineIgnoringNaN(test, test2); 
     		//asserting to ensure correct range is created
     		assertEquals(2, newRange.getLowerBound(), .000000001d);
     		assertEquals(7, newRange.getUpperBound(), .000000001d);
         }
         
         
         /*
          * This tests scale where the range object is null
          */
	      @Test(expected = IllegalArgumentException.class)
	      public void scaleWhereRangeIsNull() {
	          Range result = null;
	          result = Range.scale(null, 3);
	      }
          
          /*
           * This tests scale where the factor is greater or equal to 0 and range is not null
           */
		   @Test
		   public void scaleWhereFactorIsGreaterThenZero() {
		       Range result = new Range(2,5);
		       result = Range.scale(result, 3);
		       assertEquals(6,result.getLowerBound(),.000000001d);
		       assertEquals(15,result.getUpperBound(),.000000001d);
		   }
		           
           
           /*
            * This tests equal method where we send an object that is not of type Range
            */
            @Test
            public void testObjectNotOfRangeType() {
 	           boolean result = testRangeObj.equals(null);
 	           assertFalse(result); 
            }
            
            /*
             * This tests equal method where we send a Range object with a different lower bound
             */
             @Test
             public void testObjectDifferentLowerBound() {
	        	 Range differentLowerBound = new Range(-5.0, 10.0);
	        	 boolean result = testRangeObj.equals(differentLowerBound);
	        	 assertFalse(result); 
             }
             
             /*
              * This tests equal method where we send a Range object with a different upper bound
              */
			  @Test
			  public void testObjectDifferentUpperBound() {
				 Range differentUpperBound = new Range(-10.0, 0.0);
			
			      boolean result = testRangeObj.equals(differentUpperBound);
			      assertFalse(result); 
			  }
            
			  
			  
			  
		
			   /*
			     * This tests a value that is exactly equal to the lower bound of the test Range Object
			     */
			    @Test 
			    public void containsAtLowerBound() {
			        //Testing by asserting
			        assertTrue(testRangeObj.contains(-10.0));
			    }


			    /*
			     * This tests a value that is exactly equal to the upper bound of the test Range Object
			     */
			    @Test 
			    public void containsAtUpperBound() {
			        //Testing by asserting
			        assertTrue(testRangeObj.contains(10.0));
			    } 
			    
			    /*
			     * This tests uses the same Range object as input when calling combine()
			     */
			    @Test
			    public void combineSameRange() {
			        //Storing result from function call and testing by asserting both bounds of the result
			        Range result = Range.combine(combineObj1, combineObj1);
			        assertEquals(-20, result.getLowerBound(), .000000001d);
			        assertEquals(-10, result.getUpperBound(), .000000001d);
			    }
			    
			    /*
			        * This tests a case where the delta value input is exactly zero
			        */
			    @Test
			    public void shiftDeltaIsThanZero() {
			        //Storing result from function call and testing by asserting both bounds of the result
			        Range result = Range.shift(shiftObj, 0);
			        assertEquals(3.0, result.getLowerBound(), .000000001d);
			        assertEquals(6.0, result.getUpperBound(), .000000001d);
			    }
			    
			    /*
			     * This test getting the central value on a valid range object
			     */
			     @Test
			     public void getCentralValueValidOject() {
			         //Storing result from function call and testing by asserting the return value
			         double result = shiftObj.getCentralValue();
			         assertEquals(4.5, result, .000000001d);
			    }
			     
		     /*
		      * This test getting the length on a valid range object
		      */
		      @Test
		      public void getLengthValidOject() {
		          //Storing result from function call and testing by asserting the return value
		          double result = shiftObj.getLength();
		          assertEquals(3.0, result, .000000001d);
			     }
			      
		      /*
		       * This test turning the Range Object to a String
		       */
		       @Test
		       public void RangeToString() {
		           //Storing result from function call and testing by asserting the return value
		           Range testStringRange =  new Range(0,5);
		           String result = testStringRange.toString();
		           assertEquals("Range[" + testStringRange.getLowerBound() + "," + testStringRange.getUpperBound() + "]", result);

		       }
		       
	       /*
	         * This tests the combineIgnoringNaN method with both ranges with NaN parameters
	         */
	         @Test
	         public void combineIgnoringNaNFirstNaNSecondNaN() {
	             //Creating NaN doubles and test range object
	             double NaN = Math.sqrt(-1);
	             Range test = new Range(NaN, NaN);
	             //creating new range with test object and asserting return value
	             Range newRange = Range.combineIgnoringNaN(test, test);
	             assertNull(newRange);
	         }
	         
	         /*
	         * This tests the combineIgnoringNaN method with both ranges with NaN parameters
	         */
	         @Test
	         public void combineIgnoringNaNFirstAndSecondLowerIsNaN() {
	             //Creating NaN doubles and test range object
	             double NaN = Math.sqrt(-1);
	             Range test = new Range(NaN, NaN);
	             Range test2 = new Range(NaN, 4);
	             //creating new range with test object and asserting return value
	             Range newRange = Range.combineIgnoringNaN(test, test2);
	             assertEquals(4, newRange.getUpperBound(), .000000001d);
	         }
	         
			  /*
			  * This test getting the scaling the range object by a factor of 0
			  */
			  
			  @Test
			  public void testScaleofZero() {
					 Range newRange = Range.scale(testRangeObj, 0);
				      assertEquals(0, newRange.getLowerBound(),.000000001d);
				      assertEquals(0, newRange.getUpperBound(),.000000001d);
			  }
			  
			  /*
			  * This test getting the central value on a valid range object
			  */
			 @Test
			 public void getCentralValueOnWiderRange() {
			     //Storing result from function call and testing by asserting the return value
			     double result = combineObj2.getCentralValue();
			     assertEquals(15.0, result, .000000001d);
			 }
			  
			 /*
			  * This tests the shiftWithNoZeroCrossing() when provided a value less than 0.0
			 */
		    @Test
		    public void shiftWithNoZeroCrossingBetweenZeroAndOne() {
		    	//Storing result from function call and testing by asserting both bounds of the result
			    	Range test = new Range(0.5, 10.0);
			    	Range newShiftObj = Range.shift(test, 0.5, false);
			    	
			    	assertEquals(1.0, newShiftObj.getLowerBound(), .000000001d);
			    	assertEquals(10.5, newShiftObj.getUpperBound(), .000000001d);
			    		
		    }
		    
		    /*
			  * This tests the shiftWithNoZeroCrossing() when provided a value less than 0.0
			 */
		    @Test
		    public void shiftWithNoZeroCrossingBetweenZeroAndNegativeOne() {
		    	//Storing result from function call and testing by asserting both bounds of the result
			    	Range shiftedWithNoZeroCrossing = new Range(-0.5, 10.0);
			    	Range newShiftObj = Range.shift(shiftedWithNoZeroCrossing, 0.5, false);
			    	
			    	assertEquals(0, newShiftObj.getLowerBound(), .000000001d);
			    	assertEquals(10.5, newShiftObj.getUpperBound(), .000000001d);
			    		
		    }
		    
		    /*
		    * This tests scale where the factor is less then zero
		    */
		    @Test(expected = IllegalArgumentException.class)
		    public void scaleWhereFactorisLessThenZeroButIsAlsoADecimalAndIsGreaterThanNegativeOne() {
	         Range result = new Range(2,5);
	         result = Range.scale(result, -0.5);
		    }
		    
		    /*
		     * This test is to test the expansion of the upper and lower bound of a different Range object
		     */
			  @Test
			  public void testExpansionOfRangeWithDifferentObject() {
				  
				  Range test = new Range (1,5);
				  
				  Range expandedRange = Range.expand(test, 0.5, 0.5);
				  
				  
				  assertEquals(-1.0, expandedRange.getLowerBound(),.000000001d);
				  assertEquals(7.0, expandedRange.getUpperBound(),.000000001d);
			  }
			  
			/*
			 * This tests a range that is encapsulated (within) by the test Range Object
			 */
			@Test 
			public void intersectWithinBoundry2() {
				//Testing by asserting
				assertTrue(testRangeObj.intersects(-5.0, -1.0));
			}
			
		  /*
	      * This test the intersection of a Range being TRUE
	      */
		  @Test
		  public void testRangeIntersectionInRange() {
		      //Storing result from function call and testing by asserting the return value
		      Range intersectRange = new Range(4.0, 5.0);
		      boolean result = shiftObj.intersects(intersectRange);
		      assertTrue(result);
		      
		  }
		  
		  
		 /*
	      * This tests the constrain when the value is not contained in the range being less than the lower bound
	      */
		  @Test
		  public void constrainWhereValueisNotContainedLower2() {
		      Range test = new Range(1,5);
		      double result = test.constrain(0);
		      assertEquals(1, result,.000000001d);
	      }
		  
		  
		 
        /*
       * This tests the isNaNRange function with a non-NaN range
       */
        @Test
        public void isNaNRangeNoNaN() {
    		//creating new range object and calling the method in question
    		Range test = new Range(1,2); 
    		boolean result = test.isNaNRange();
    		//asserting to ensure correct range is created
    		assertFalse(result);
        }
        
        
        /*
       * This tests the isNaNRange function with a NaN range
       */
        @Test
        public void isNaNRangeNaN() {
        	//Creating NaN double
    		double NaN = Math.sqrt(-1); 
    		//creating new range object and calling the method in question
    		Range test = new Range(NaN, NaN); 
    		boolean result = test.isNaNRange();
    		//asserting to ensure correct range is created
    		assertTrue(result);
        }
        
        /*
       * This tests the isNaNRange function with a semi NaN range
       */
        @Test
        public void isNaNRangeFirstNaN() {
        	//Creating NaN double
    		double NaN = Math.sqrt(-1); 
    		//creating new range object and calling the method in question
    		Range test = new Range(NaN, 1); 
    		boolean result = test.isNaNRange();
    		//asserting to ensure correct range is created
    		assertFalse(result);
        } 
        
        
        /*
       * This tests the isNaNRange function with a semi NaN range
       */
        @Test
        public void isNaNRangeSecondNaN() {
        	//Creating NaN double
    		double NaN = Math.sqrt(-1); 
    		//creating new range object and calling the method in question
    		Range test = new Range(1, NaN); 
    		boolean result = test.isNaNRange();
    		//asserting to ensure correct range is created
    		assertFalse(result);
        }
        
    	@Test
    	public void hashZeroValues() {
    		Range test = new Range(0, 0);
    		assertEquals(0.0, test.hashCode(), .000000001d);
    	}
   	
	   	@Test
	   	public void hashValidValues() {
	   		Range test = new Range(4, 5);
	   		assertEquals(-2.115764224E9, test.hashCode(), .000000001d);
	   	}
	   	
	   	@Test
	   	public void hashNegativeValidValues() {
	   		Range test = new Range(-5, -2);
	   		assertEquals(-2.109472768E9, test.hashCode(), .000000001d);
	   	}
	   	
	   	
	   	@Test(expected = IllegalArgumentException.class)
	   	public void hashInvalidRangeValues() {
	   		Range test = new Range(4, 2);
	   		test.hashCode();
	   	}
	   	
	   	@Test
	   	public void shiftZeroValueShiftPositiveValidValue() {
	   		Range test = new Range(0, 0);
	   		Range result = Range.shift(test, 1.2);
	   		Range expected = new Range(1.2, 1.2);
	   		assertEquals(result, expected);
	   	}
	   	
	   	@Test
	   	public void shiftZeroValueShiftNegativeValidValue() {
	   		Range test = new Range(0, 0);
	   		Range result = Range.shift(test, -1.2);
	   		Range expected = new Range(-1.2, -1.2);
	   		assertEquals(result, expected);
	   	}
	   	  		
	   	@Test(expected = IllegalArgumentException.class)
	   	public void shiftNull() {
	   		Range test = null;
	   		Range result = Range.shift(test, 1.2);
	   	}
	   	
	
	   	@Test
	   	public void intersectsValidRangePositiveSameValues() {
	   		Range test = new Range(4, 10);
	   		assertTrue(test.intersects(5, 5));
	   	}
	   	
	   	@Test
	   	public void intersectsValidRangeTouchingUpperBoundSameValues() {
	   		Range test = new Range(4, 10);
	   		assertTrue(test.intersects(10, 10));
	   	}
	   	
	   	@Test
	   	public void intersectsValidRangeTouchingLowerBoundSameValues() {
	   		Range test = new Range(4, 10);
	   		assertTrue(test.intersects(4, 4));
	   	}
	   	
	   	@Test
	   	public void intersectsValidRangeValidReversedRangeBoundaries() {
	   		Range test = new Range(4, 10);
	   		assertFalse(test.intersects(100, 10));
	   	}
	
	   	@Test
	   	public void intersectsValidRangeNegativeSameValues() {
	   		Range test = new Range(-18,-12);
	   		assertTrue(test.intersects(-14, -14));
	   	}
	   	
	   	@Test
	   	public void intersectsValidRangeNegativeTouchingUpperBoundSameValues() {
	   		Range test = new Range(-18,-12);
	   		assertTrue(test.intersects(-12,-12));
	   	}
	
	   	@Test
	   	public void intersectsValidRangeNegativeTouchingLowerBoundSameValues() {
	   		Range test = new Range(-18,-12);
	   		assertTrue(test.intersects(-18, -18));
	   	}
	   	
	   	@Test(expected = IllegalArgumentException.class)
	   	public void expandNull() {
	   		Range test = null;
	   		Range.expand(test, 1, 2);
	   	}
	   	
	   	@Test
	   	public void rangeConstructorErrorMessage() {
	   		String msg = "";
	   		double lower = 10;
	   		double upper = 5;
	   		try {
	   			Range test = new Range(lower, upper);
	   		} catch (IllegalArgumentException e) {
	   			msg = e.getMessage();
	   		}
	   		
	   		assertEquals("Range(double, double): require lower (" + lower + ") <= upper (" + upper + ").", msg);
	   	}

	
		  
}






