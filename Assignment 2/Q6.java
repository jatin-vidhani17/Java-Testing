class strBuffer{
    public static void main(String[] args) {
        StringBuffer bufferString = new StringBuffer();

        System.out.println("Initial capacity : " + bufferString.capacity());
        System.out.println("Initial length : " + bufferString.length());

        bufferString.append('H');
        bufferString.append('e');
        bufferString.append('l');
        bufferString.append('l');
        bufferString.append('o');
        bufferString.append(" There!!, This Code is for Testing Purpose.");
        
        System.out.println("Contents of StringBuffer : " + bufferString.toString());

        System.out.println("Capacity after appending : " + bufferString.capacity());
        System.out.println("Length after appending : " + bufferString.length());
    }
}

/*

Output : 

Initial capacity : 16
Initial length : 0
Contents of StringBuffer : Hello There!!, This Code is for Testing Purpose.
Capacity after appending : 48
Length after appending : 48

*/
