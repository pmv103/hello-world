package com.utilityservice;

/**
 * Code Description: To determine prime factors for a given no
 * 
 * Creation Date: 16-Jan-2018
 * 
 * Version: 1.0
 * 
 * @author Pradeepkumar
 */

public class PrimeFactor {

	private static final String MSG_INVALID_INPUT = "Prime factors can not be determined for the given input. Kindly provide any absolute no, which is greater than 1.";
	private static final String MSG_SUCCESS = "Prime factor(s) are: ";
	private static final String MSG_PRIME_NUMBER = "Given number itself is a prime number, hence prime factors can not be determined.";
	private static final String MSG_ERROR = "Exception occurred. ";
	private static final String MSG_INPUTLENGTH_ERROR = "Input length is exceeded. Please provide value upto 9223372036854775807.";

	/**
	 * 
	 * @param numString
	 * @return
	 */
	public static String getPrimeFactors(String numString) {

		/**
		 * StringBuilder is used to print the prime factors
		 */
		StringBuilder stb = new StringBuilder();

		try {

			// Accept only positive Integer
			if (!numString.matches("\\d+")) {
				return MSG_INVALID_INPUT;
			}

			// Long accept value is less than or equal to (2^63 - 1)
			long number = Long.valueOf(numString);
			long inputNumber = number;

			// If number less than 2, prompt the appropriate message.
			if (number < 2) {
				return MSG_INVALID_INPUT;
			}

			// calculate prime factors of given number
			for (long i = 2; i <= number / i; i++) {

				while (number % i == 0) {
					number = number / i;
					stb.append(i).append(" ");
				}

			}

			if (number > 1) {
				stb.append(number);
			}

			if (String.valueOf(inputNumber).equals(stb.toString())) {
				return MSG_PRIME_NUMBER;
			}

		} catch (NumberFormatException nfme) {
			return MSG_INPUTLENGTH_ERROR;
		} catch (Exception e) {
			return MSG_ERROR;
		}

		return MSG_SUCCESS + stb.toString();
	}

}
