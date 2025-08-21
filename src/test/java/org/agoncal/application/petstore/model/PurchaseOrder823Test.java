package org.agoncal.application.petstore.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import javax.persistence;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PurchaseOrder823Test {

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void compareIdenticalInstances() {

		Address deliveryAddress = new Address("123 Main St", "Springfield", "12345", new Country());
		Customer customer = new Customer("John", "Doe", "johndoe", "password123", "johndoe@example.com",
				deliveryAddress);
		CreditCard creditCard = new CreditCard("1234567890123456", CreditCardType.VISA, "12/25");
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(customer, creditCard, deliveryAddress);

		purchaseOrder1.setOrderDate(new Date());
		PurchaseOrder purchaseOrder2 = new PurchaseOrder(customer, creditCard, deliveryAddress);

		purchaseOrder2.setOrderDate(purchaseOrder1.getOrderDate());

		boolean result = purchaseOrder1.equals(purchaseOrder2);

		assertTrue(result, "Identical PurchaseOrder instances should be equal");
	}

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void compareWithNullInstance() {

		Address deliveryAddress = new Address("123 Main St", "Springfield", "12345", new Country());
		Customer customer = new Customer("John", "Doe", "johndoe", "password123", "johndoe@example.com",
				deliveryAddress);
		CreditCard creditCard = new CreditCard("1234567890123456", CreditCardType.VISA, "12/25");
		PurchaseOrder purchaseOrder = new PurchaseOrder(customer, creditCard, deliveryAddress);

		purchaseOrder.setOrderDate(new Date());

		boolean result = purchaseOrder.equals(null);

		assertFalse(result, "Comparing with null should return false");
	}

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void compareWithDifferentClass() {

		Address deliveryAddress = new Address("123 Main St", "Springfield", "12345", new Country());
		Customer customer = new Customer("John", "Doe", "johndoe", "password123", "johndoe@example.com",
				deliveryAddress);
		CreditCard creditCard = new CreditCard("1234567890123456", CreditCardType.VISA, "12/25");
		PurchaseOrder purchaseOrder = new PurchaseOrder(customer, creditCard, deliveryAddress);

		purchaseOrder.setOrderDate(new Date());
		String differentObject = "NotAPurchaseOrder";

		boolean result = purchaseOrder.equals(differentObject);

		assertFalse(result, "Comparing with an object of different class should return false");
	}

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void compareWithNullFields() {

		PurchaseOrder purchaseOrder1 = new PurchaseOrder();

		purchaseOrder1.setOrderDate(null);

		purchaseOrder1.setCustomer(null);
		PurchaseOrder purchaseOrder2 = new PurchaseOrder();

		purchaseOrder2.setOrderDate(null);

		purchaseOrder2.setCustomer(null);

		boolean result = purchaseOrder1.equals(purchaseOrder2);

		assertTrue(result, "PurchaseOrder with identical null fields should be equal");
	}

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void compareWithDifferentCustomer() {

		Address deliveryAddress = new Address("123 Main St", "Springfield", "12345", new Country());
		Customer customer1 = new Customer("John", "Doe", "johndoe", "password123", "johndoe@example.com",
				deliveryAddress);
		Customer customer2 = new Customer("Jane", "Smith", "janesmith", "password456", "janesmith@example.com",
				deliveryAddress);
		CreditCard creditCard = new CreditCard("1234567890123456", CreditCardType.VISA, "12/25");
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(customer1, creditCard, deliveryAddress);

		purchaseOrder1.setOrderDate(new Date());
		PurchaseOrder purchaseOrder2 = new PurchaseOrder(customer2, creditCard, deliveryAddress);
		purchaseOrder2.setOrderDate(purchaseOrder1.getOrderDate());

		boolean result = purchaseOrder1.equals(purchaseOrder2);

		assertFalse(result, "PurchaseOrders with different customers should not be equal");
	}

	/*
	 * ROOST_METHOD_HASH=equals_f7b93a45e3 ROOST_METHOD_SIG_HASH=equals_f2d574000d
	 *
	 */public void verifyEqualsContract() {

		Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
			EqualsVerifier.forClass(PurchaseOrder.class).verify();
		});

		assertTrue(thrown.getMessage().contains("Proper equality contract violation")
				|| thrown.getMessage().contains("ensure both domains obey symm, consistency not met."));
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringBaseCase() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		String expected = "PurchaseOrder{id=null, version=0, orderDate=null, totalWithoutVat=null, vatRate=null, vat=null, totalWithVat=null, discountRate=null, discount=null, total=null, customer=null, orderLines=[], deliveryAddress=null, creditCard=null}";
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringFullyPopulated() {
		Customer customer = new Customer("John", "Doe", "jdoe", "password123", "john.doe@example.com", new Address());
		CreditCard creditCard = new CreditCard("1234567890123456", CreditCardType.VISA, "12/23");
		Address deliveryAddress = new Address("123 Main St", "Springfield", "12345", new Country());
		PurchaseOrder purchaseOrder = new PurchaseOrder(customer, creditCard, deliveryAddress);

		purchaseOrder.id = 1L;

		purchaseOrder.orderDate = new Date();

		purchaseOrder.totalWithoutVat = 100.0f;

		purchaseOrder.vatRate = 10.0f;

		purchaseOrder.vat = 10.0f;

		purchaseOrder.totalWithVat = 110.0f;

		purchaseOrder.discountRate = 5.0f;

		purchaseOrder.discount = 5.0f;

		purchaseOrder.total = 105.0f;
		String expected = "PurchaseOrder{id=1, version=0, orderDate=" + purchaseOrder.orderDate
				+ ", totalWithoutVat=100.0, vatRate=10.0, vat=10.0, totalWithVat=110.0, discountRate=5.0, discount=5.0, total=105.0, customer="
				+ customer.toString() + ", orderLines=[], deliveryAddress=" + deliveryAddress.toString()
				+ ", creditCard=" + creditCard.toString() + '}';
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringWithNullNestedObjects() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		String expected = "PurchaseOrder{id=null, version=0, orderDate=null, totalWithoutVat=null, vatRate=null, vat=null, totalWithVat=null, discountRate=null, discount=null, total=null, customer=null, orderLines=[], deliveryAddress=null, creditCard=null}";
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringWithEmptyOrderLines() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.orderLines = new HashSet<>();
		String expected = "PurchaseOrder{id=null, version=0, orderDate=null, totalWithoutVat=null, vatRate=null, vat=null, totalWithVat=null, discountRate=null, discount=null, total=null, customer=null, orderLines=[], deliveryAddress=null, creditCard=null}";
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringWithPartialFieldPopulation() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		purchaseOrder.id = 1L;

		purchaseOrder.version = 1;

		purchaseOrder.orderDate = new Date();
		String expected = "PurchaseOrder{id=1, version=1, orderDate=" + purchaseOrder.orderDate
				+ ", totalWithoutVat=null, vatRate=null, vat=null, totalWithVat=null, discountRate=null, discount=null, total=null, customer=null, orderLines=[], deliveryAddress=null, creditCard=null}";
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringWithFloatingPointFields() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.vatRate = 0.0f;
		purchaseOrder.totalWithVat = -10.0f;
		purchaseOrder.totalWithoutVat = 10.5f;
		String expected = "PurchaseOrder{id=null, version=0, orderDate=null, totalWithoutVat=10.5, vatRate=0.0, vat=null, totalWithVat=-10.0, discountRate=null, discount=null, total=null, customer=null, orderLines=[], deliveryAddress=null, creditCard=null}";
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringNestedObjectIntegration() {
		Customer customer = new Customer("Jane", "Doe", "jdoe2", "password456", "jane.doe@example.com", new Address());
		CreditCard creditCard = new CreditCard("9876543210987654", CreditCardType.MASTER_CARD, "11/24");
		Address deliveryAddress = new Address("456 Elm St", "Shelbyville", "54321", new Country());
		PurchaseOrder purchaseOrder = new PurchaseOrder(customer, creditCard, deliveryAddress);
		String expected = "PurchaseOrder{id=null, version=0, orderDate=null, totalWithoutVat=null, vatRate=null, vat=null, totalWithVat=null, discountRate=null, discount=null, total=null, customer="
				+ customer.toString() + ", orderLines=[], deliveryAddress=" + deliveryAddress.toString()
				+ ", creditCard=" + creditCard.toString() + '}';
		assertEquals(expected, purchaseOrder.toString());
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringWithLargeOrderLines() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.orderLines = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			OrderLine orderLine = new OrderLine();
			orderLine.setQuantity(i);
			purchaseOrder.orderLines.add(orderLine);
		}
		assertTrue(purchaseOrder.toString().contains("PurchaseOrder"));
		assertTrue(purchaseOrder.toString().contains("orderLines=["));
	}

	/*
	 * ROOST_METHOD_HASH=toString_0072ad12b8 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void verifyToStringFieldSpecificFormattingForDates() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.orderDate = new Date();

		String orderDateString = purchaseOrder.orderDate.toString();
		assertTrue(purchaseOrder.toString().contains(orderDateString));
	}

}