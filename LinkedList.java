
class LinkedList {
    Node head;

    
    LinkedList() {
        this.head = null;
    }

  
    public void addNodeAtBeginning(Buku data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

   
    public void addNodeAtEnd(Buku data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

   
    public void addNodeAtIndex(int index, Buku data) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Indeks tidak valid.");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

   
    public void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        head = head.next;
    }

   
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

   
    public void deleteNodeByTitle(String title) {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        if (head.data.judul.equals(title)) {
            head = head.next;
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null && !current.data.judul.equals(title)) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Buku dengan judul \"" + title + "\" tidak ditemukan.");
        }
    }

    
    public void printList() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            temp.data.displayInfo();
            temp = temp.next;
        }
    }
}