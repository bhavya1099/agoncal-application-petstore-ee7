package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import javax.persistence;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

public class OrderLine129Test {

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsTrueWhenComparingWithSelf() {

		Item item = new Item();
		item.setId(1L);
		item.setName("Test Item");
		OrderLine orderLine = new OrderLine(10, item);

		boolean result = orderLine.equals(orderLine);

		assertTrue(result, "The equals method should return true when comparing an object with itself.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsTrueForEqualOrderLineObjects() {

		Item item = new Item();
		item.setId(2L);
		item.setName("Sample Item");
		OrderLine orderLine1 = new OrderLine(5, item);
		OrderLine orderLine2 = new OrderLine(5, item);

		boolean result = orderLine1.equals(orderLine2);

		assertTrue(result, "The equals method should return true when comparing two equal OrderLine objects.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseForDifferentOrderLineObjects() {

		Item item1 = new Item();
		item1.setId(3L);
		item1.setName("Item One");
		Item item2 = new Item();
		item2.setId(4L);
		item2.setName("Item Two");
		OrderLine orderLine1 = new OrderLine(10, item1);
		OrderLine orderLine2 = new OrderLine(20, item2);

		boolean result = orderLine1.equals(orderLine2);

		assertFalse(result, "The equals method should return false when comparing two different OrderLine objects.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseWhenObjectIsNull() {

		Item item = new Item();
		item.setId(5L);
		item.setName("Valid Item");
		OrderLine orderLine = new OrderLine(30, item);

		boolean result = orderLine.equals(null);

		assertFalse(result, "The equals method should return false when comparing OrderLine with a null object.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsReturnsFalseWhenComparingDifferentClassType() {

		Item item = new Item();
		item.setId(6L);
		item.setName("Item");
		OrderLine orderLine = new OrderLine(15, item);
		String anotherClassObject = "Not an OrderLine";

		boolean result = orderLine.equals(anotherClassObject);

		assertFalse(result,
				"The equals method should return false when comparing OrderLine with an object of a different class.");
	}

	/*
	 * ROOST_METHOD_HASH=equals_9577507f17 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void equalsHandlesBoundaryCaseOfEmptyOrderLine() {

		OrderLine emptyOrderLine1 = new OrderLine();
		OrderLine emptyOrderLine2 = new OrderLine();

		boolean result = emptyOrderLine1.equals(emptyOrderLine2);

		assertFalse(result,
				"The equals method should return false when comparing two empty OrderLine objects without initialized fields.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5bc10b463 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringWithAllNullFields() {

		OrderLine orderLine = new OrderLine();

		String actualToString = orderLine.toString();

		String expectedToString = "OrderLine{id=null, version=null, quantity=null, item=null}";
		assertEquals(expectedToString, actualToString);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5bc10b463 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringWithValidFields() {

		Item item = new Item();
		item.setId(1L);

		OrderLine orderLine = new OrderLine(5, item);

		String actualToString = orderLine.toString();

		String expectedToString = "OrderLine{id=null, version=null, quantity=5, item=Item{id=1, version=null, name=null, description=null, imagePath=null, unitCost=null, product=null}}";
		assertNotNull(actualToString);
		assertEquals(expectedToString, actualToString);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5bc10b463 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringWithNullInvalidScenario() {

		OrderLine orderLine = new OrderLine();

		String actualToString = orderLine.toString();

		assertNotNull(actualToString);
		assertTrue(actualToString.contains("OrderLine"));
		assertEquals("OrderLine{id=null, version=null, quantity=null, item=null}", actualToString);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5bc10b463 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringBoundaryConditionWithLargeQuantity() {

		Item item = new Item();
		item.setName("Sample Item");

		OrderLine orderLine = new OrderLine(Integer.MAX_VALUE, item);

		String actualToString = orderLine.toString();

		assertNotNull(actualToString);
		assertTrue(actualToString.contains("quantity=" + Integer.MAX_VALUE));
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5bc10b463 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void toStringIntegrationWithItemObject() {

		Item item = new Item();
		item.setName("Integration Test Item");

		OrderLine orderLine = new OrderLine(10, item);

		String actualToString = orderLine.toString();

		assertNotNull(actualToString);
		assertTrue(actualToString.contains("Integration Test Item"));
	}

}