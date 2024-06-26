This document provides the solution for a technical assessment for the position of Programmer (P). 
The assessment includes Java programs for algorithmic questions and SQL queries for database-related tasks. 
The tasks and solutions are detailed below.

I'm using Java & POSTGRESQL to solve this task. The JAVA task can run independently because it has its own main.

## Task 1: Algorithm for Special Number Printing

### Problem Statement
Create an algorithm to display numbers from 1 to `n` with the following rules:
- Multiples of 3 should be replaced with "OK"
- Multiples of 4 should be replaced with "YES"
- Multiples of both 3 and 4 should be replaced with "OKYES"

### Solution
The following Java code solves the problem:

```java
public class Soal1 {
    public static void main(String[] args) {
        Integer num = 15;

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.print(" OKYES ");
            } else if (i % 3 == 0) {
                System.out.print(" OK ");
            } else if (i % 4 == 0) {
                System.out.print(" YES ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
    }
}
```

## Task 2: Pattern Printing

### Problem Statement
Write an algorithm to display various patterns for a given `n`.

### Solution
The following Java code solves the problem:

```java
public class Soal2 {
    public static void main(String[] args) {
        Integer n = 5;

        System.out.println("Soal 2A:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();

        // b. pattern
        System.out.println("Soal 2B:");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();

        // c. pattern
        System.out.println("Soal 2C:");
        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }

        System.out.println();

        // d. pattern
        System.out.println("Soal 2D:");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + j * n) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
```

## Task 3: Array Manipulation

### Problem Statement
Given an array, remove all multiples of 3 and sort the remaining numbers in ascending order.

### Solution
The following Java code solves the problem:

```java
import java.util.Arrays;

public class Soal3 {
    public static void main(String[] args) {
        int[] numList = {12, 9, 13, 6, 10, 4, 7, 2};

        numList = Arrays.stream(numList).filter(i -> i % 3 != 0).toArray();
        Arrays.sort(numList);
        System.out.print("n = [");
        for (int i = 0; i < numList.length; i++) {
            System.out.print(numList[i]);
            if (i < numList.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

## Task 4: SQL Queries for Database Operations

### Problem Statement
Write SQL queries to display specific data from the provided tables.

### Solution
The following SQL scripts solve the problem. 
Make sure to create and populate the tables as shown below before executing the queries.

```sql
-- Create the 'pelanggan' table
CREATE TABLE pelanggan (
    KODE VARCHAR(11) PRIMARY KEY,
    NAMA VARCHAR(255),
    ALAMAT VARCHAR(255)
);

-- Create the 'barang' table
CREATE TABLE barang (
    KODE VARCHAR(255) PRIMARY KEY,
    NAMA VARCHAR(255),
    HARGA DOUBLE PRECISION
);

-- Create the 'transaksi' table
CREATE TABLE transaksi (
    KODE VARCHAR(255) PRIMARY KEY,
    TANGGAL DATE,
    KODE_PELANGGAN VARCHAR(255),
    KODE_BARANG VARCHAR(255),
    JUMLAH_BARANG DOUBLE PRECISION,
    FOREIGN KEY (KODE_PELANGGAN) REFERENCES pelanggan(KODE),
    FOREIGN KEY (KODE_BARANG) REFERENCES barang(KODE)
);

-- Insert records into 'barang' table
INSERT INTO barang (KODE, NAMA, HARGA)
VALUES
('B1', 'Baju', 12000),
('B2', 'Celana', 10000),
('B3', 'Sepatu', 30000);

-- Insert records into 'pelanggan' table
INSERT INTO pelanggan (KODE, NAMA, ALAMAT)
VALUES
('P1', 'Yogi', 'JAKARTA'),
('P2', 'Anggi', 'BANDUNG'),
('P3', 'Rahma', 'BANDUNG');

-- Insert records into 'transaksi' table
INSERT INTO transaksi (KODE, TANGGAL, KODE_PELANGGAN, KODE_BARANG, JUMLAH_BARANG)
VALUES
('TRX001', '2019-10-01', 'P1', 'B1', 3),
('TRX002', '2019-10-02', 'P2', 'B2', 2),
('TRX003', '2019-10-08', 'P2', 'B1', 5),
('TRX004', '2019-10-10', 'P1', 'B1', 1),
('TRX005', '2019-10-17', 'P3', 'B2', 2),
('TRX006', '2019-10-17', 'P2', 'B3', 1),
('TRX007', '2019-10-18', 'P3', 'B1', 4),
('TRX008', '2019-10-18', 'P2', 'B2', 2);
```

### SQL Queries
```sql
-- Query 4A: Select items with price greater than 10,000 sorted by price ascending
SELECT *
FROM barang
WHERE HARGA > 10000
ORDER BY HARGA ASC;

-- Query 4B: Select customers with 'g' in their name and located in 'BANDUNG'
SELECT *
FROM pelanggan
WHERE NAMA LIKE '%g%' AND ALAMAT = 'BANDUNG';

-- Query 4C: Detailed transaction data
SELECT t.KODE AS "KODE",
       t.TANGGAL AS "TANGGAL",
       p.NAMA AS "NAMA PELANGGAN",
       b.NAMA AS "NAMA BARANG",
       t.JUMLAH_BARANG AS "JUMLAH",
       b.HARGA AS "HARGA SATUAN",
       (b.HARGA * t.JUMLAH_BARANG) AS "TOTAL"
FROM transaksi t
JOIN barang b ON t.KODE_BARANG = b.KODE
JOIN pelanggan p ON t.KODE_PELANGGAN = p.KODE
ORDER BY p.NAMA, b.HARGA ASC;

-- Query 4D: Total items and total purchase amount per customer
SELECT p.NAMA AS "NAMA PELANGGAN",
       SUM(t.JUMLAH_BARANG) AS "JUMLAH",
       SUM(b.HARGA * t.JUMLAH_BARANG) AS "TOTAL HARGA"
FROM transaksi t
JOIN barang b ON t.KODE_BARANG = b.KODE
JOIN pelanggan p ON t.KODE_PELANGGAN = p.KODE
GROUP BY p.NAMA
ORDER BY p.NAMA;
```
