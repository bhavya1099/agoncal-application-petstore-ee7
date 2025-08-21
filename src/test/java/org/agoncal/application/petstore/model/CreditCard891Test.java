package org.agoncal.application.petstore.model;

import java.io.Serializable;
import java.util.Objects;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCard891Test {

	/*
	 * ROOST_METHOD_HASH=equals_605f6dee1c ROOST_METHOD_SIG_HASH=equals_75d7bf0c01
	 *
	 */public void equalsReturnsTrueWhenComparingSameInstance() {

		CreditCard creditCard = new CreditCard("1234567890", CreditCardType.VISA, "12/25");

		boolean result = creditCard.equals(creditCard);

		org.junit.jupiter.api.Assertions.assertTrue(result);
	}

	/*
	 * ROOST_METHOD_HASH=equals_605f6dee1c ROOST_METHOD_SIG_HASH=equals_75d7bf0c01
	 *
	 */public void equalsReturnsFalseWhenComparingWithNull() {

		CreditCard creditCard = new CreditCard("1234567890", CreditCardType.VISA, "12/25");

		boolean result = creditCard.equals(null);

		org.junit.jupiter.api.Assertions.assertFalse(result);
	}

	/*
	 * ROOST_METHOD_HASH=equals_605f6dee1c ROOST_METHOD_SIG_HASH=equals_75d7bf0c01
	 *
	 */public void equalsReturnsTrueWhenComparingEqualObjects() {

		CreditCard creditCard1 = new CreditCard("1234567890", CreditCardType.VISA, "12/25");
		CreditCard creditCard2 = new CreditCard("1234567890", CreditCardType.VISA, "12/25");

		boolean result = creditCard1.equals(creditCard2);

		org.junit.jupiter.api.Assertions.assertTrue(result);
	}

	/*
	 * ROOST_METHOD_HASH=equals_605f6dee1c ROOST_METHOD_SIG_HASH=equals_75d7bf0c01
	 *
	 */public void equalsReturnsFalseWhenComparingDifferentObjects() {

		CreditCard creditCard1 = new CreditCard("1234567890", CreditCardType.VISA, "12/25");
		CreditCard creditCard2 = new CreditCard("0987654321", CreditCardType.MASTER, "11/23");

		boolean result = creditCard1.equals(creditCard2);

		org.junit.jupiter.api.Assertions.assertFalse(result);
	}

	/*
	 * ROOST_METHOD_HASH=equals_605f6dee1c ROOST_METHOD_SIG_HASH=equals_75d7bf0c01
	 *
	 */public void equalsReturnsFalseWhenComparingWithDifferentType() {

		CreditCard creditCard = new CreditCard("1234567890", CreditCardType.VISA, "12/25");
		Object randomObject = new Object();

		boolean result = creditCard.equals(randomObject);

		org.junit.jupiter.api.Assertions.assertFalse(result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5941ddaa3 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateToStringWithNullValues() {

		CreditCard creditCard = new CreditCard();

		String actualOutput = creditCard.toString();

		assertEquals("CreditCard{creditCardNumber='null', creditCardType=null, creditCardExpDate='null'}",
				actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5941ddaa3 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateToStringWithAllFieldsPopulated() {

		CreditCardType creditCardType = CreditCardType.VISA;
		CreditCard creditCard = new CreditCard("1234567890123456", creditCardType, "12/30");

		String actualOutput = creditCard.toString();

		assertEquals("CreditCard{creditCardNumber='1234567890123456', creditCardType=VISA, creditCardExpDate='12/30'}",
				actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5941ddaa3 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateToStringWithEmptyCreditCardNumber() {

		CreditCardType creditCardType = CreditCardType.MASTERCARD;
		CreditCard creditCard = new CreditCard("", creditCardType, "01/29");

		String actualOutput = creditCard.toString();

		assertEquals("CreditCard{creditCardNumber='', creditCardType=MASTERCARD, creditCardExpDate='01/29'}",
				actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5941ddaa3 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateToStringWithNullCreditCardType() {

		CreditCard creditCard = new CreditCard("1234567890123456", null, "12/30");

		String actualOutput = creditCard.toString();

		assertEquals("CreditCard{creditCardNumber='1234567890123456', creditCardType=null, creditCardExpDate='12/30'}",
				actualOutput);
	}

	/*
	 * ROOST_METHOD_HASH=toString_e5941ddaa3 ROOST_METHOD_SIG_HASH=toString_ceffa8036e
	 *
	 */public void validateToStringWithEmptyExpDate() {

		CreditCardType creditCardType = CreditCardType.VISA;
		CreditCard creditCard = new CreditCard("1234567890123456", creditCardType, "");

		String actualOutput = creditCard.toString();

		assertEquals("CreditCard{creditCardNumber='1234567890123456', creditCardType=VISA, creditCardExpDate=''}",
				actualOutput);
	}

}