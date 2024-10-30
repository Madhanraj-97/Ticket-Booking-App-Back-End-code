package com.spring_project.Ticket_booking_webApp;

public class Task {
	public static void main(String[] args) {
		String input = "     welcome   to  merfentz    ";
		int first = 0, last = 0, mid = 0;
		char[] ch = input.toCharArray();
		int length = findLenth(ch);
		int i = 0;
		String res =removeSpace(ch, length);
		while (i < length) {
			if (i == 0 && ch[i] == ' ') {
				first = spaceCount(i, ch, length);
				i = first;
			} else if (i == length - 1 && ch[i] == ' ') {
				last = lastSpace(i++, ch, length);

			} else if (i > 0 && (ch[i] == ' ' && ch[i - 1] != ' ')) {
				int count = middleSpace(i, ch, length);
				mid += count;
				i += count;
				if (count == 0) {
					i++;
				}
			} else {
				i++;
			}
		}

		System.out.println("first " + first);
		System.out.println("last " + last);
		System.out.println("mid " + mid);
		System.out.println("result ==" +res+".");
	}

	public static String removeSpace(char[] ch, int length) {
		String str ="";
		for (int i = 0; i < length; i++) {
			if (ch[i] != ' ') {
				str += ch[i];
			} else if (i > 0 && ch[i] == ' ' && ch[i - 1] != ' ') {
				str += ch[i];
			}
		}
		char[] ch1=str.toCharArray();
		int len=findLenth(ch1);       
		str="";
		for(int i=0;i<len-1;i++) {
			str+=ch1[i];
		}
		return str;
	}

	public static int findLenth(char[] arr) {
		int count = 0;
		for (char c : arr) {
			count += 1;
		}
		return count;
	}

	public static int spaceCount(int index, char[] c, int lenght) {
		int count = 0;
		for (int i = index; i < lenght; i++) {
			if (c[i] == ' ') {
				count += 1;
			} else {
				break;
			}
		}
		return count;
	}

	public static int lastSpace(int i, char[] c, int lenght) {
		int count = 0;
		for (int j = i; c[j] == ' '; j--) {
			count++;
		}
		return count;
	}

	public static int middleSpace(int i, char[] c, int lenght) {
		System.out.println(i);
		int count = 0;
		for (int j = i; j < lenght; j++) {
			if (c[j] == ' ') {
				count += 1;

			} else {
				break;
			}
			i++;
		}
		if (i == lenght) {
			return 0;
		}
		return count;
	}

}
