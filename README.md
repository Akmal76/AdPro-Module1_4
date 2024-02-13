# tutorial-1
**Tutorial Pemrograman Lanjut (Advanced Programming) 2023/2024 Genap**
* Nama    : Akmal Ramadhan
* NPM     : 2206081534
* Kelas   : Pemrograman Lanjut - A

# Module 2: CI/CD & Dev Ops
### SonarCloud Report
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Akmal76_tutorial-1&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Akmal76_tutorial-1)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Akmal76_tutorial-1&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Akmal76_tutorial-1)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Akmal76_tutorial-1&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Akmal76_tutorial-1)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Akmal76_tutorial-1&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Akmal76_tutorial-1)

### [ADVShop (E-Shop)](https://adpro-akmal76.koyeb.app/)
Aplikasi dapat diakses melalui link diatas.

## Reflection

### Daftar Isu _Code Quality_ yang Diperbaiki
Berikut adalah isu-isu _code quality_ yang dideteksi oleh PMD dan SonarCloud yang saya perbaiki:
#### 1. **Position literals first in String comparisons**

**Permasalahan:** Perlu memposisikan _literals_ terlebih dahulu dalam perbandingan _String_. Jika tidak, apabila argumen
`.equals()` bernilai `null`, maka akan terjadi _NullPointerException_.

**Contoh Isu pada Proyek**:
```java
if (product.getProductName().equals("")) product.setProductName("Produk Tidak Diketahui");
```
**Solusi:** Menukar kedua argumen pada perbandingan _String_.
```java
if ("".equals(product.getProductName())) product.setProductName("Produk Tidak Diketahui");
```

#### 2. **This statement should have braces**

**Permasalahan:** Pernyataan percabangan atau perulangan yang tidak memiliki _braces_ `{}`.

**Contoh Isu pada Proyek:**
```java
if (product.getProductQuantity() < 0) product.setProductQuantity(0);
```
**Solusi:** Menambahkan _braces_ `{}` pada pernyataan tersebut.
```java
if (product.getProductQuantity() < 0) {
    product.setProductQuantity(0);
}
```

#### 3. **Unnecessary modifier `public` on method `...`: the method is declared in an interface type**

**Permasalahan:** _Modifier_ `public` tidak diperlukan karena dalam _interface_ sudah secara _default_
bersifat `public`.

**Contoh Isu pada Proyek:**
```java
public interface ProductService {
    public Product create (Product product);
}
```

**Solusi:** Menghapus _modifier_ `public` pada _method_ tersebut.
```java
public interface ProductService {
    Product create (Product product);
}
```

#### 4. **Unused import `org.springframework.web.bind.annotation.*`**
Permasalahan tidak relevan, karena _import_ tersebut memang tidak digunakan. 

#### 5. **Missing Description**

**Permasalahan:** Komentar yang tidak jelas atau tidak ada.

**Contoh Isu pada Proyek:**
```html
<table border="1" class="table table-striped table-responsive-md">
    <thead>
    <tr>
        <th scope="col">Product Name</th>
```
**Solusi:** Menambahkan komentar yang jelas pada _tag_ `<table>`.
```html
<table border="1" class="table table-striped table-responsive-md">
    <!-- Tabel untuk menampilkan produk dengan detail nama, kuantitas, dan tombol edit serta delete -->
    <thead>
    <tr>
        <th scope="col">Product Name</th>
```

#### 6. **`as` pada Dockerfile**

**Contoh Isu pada Proyek:**
```Dockerfile
FROM docker.io/library/eclipse-temurin:21-jdk-alpine as builder
```

**Solusi:** Mengubah `as` menjadi `AS` pada _Dockerfile_.
```Dockerfile
FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS builder
```

#### 7. **Unused Private Modifier**

**Permasalahan:** Terdapat _modifier private_ yang tidak berguna.

**Contoh Isu pada Proyek:**
```java
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;
    ...
}
```

**Solusi:** Menghapus _modifier private_ yang tidak berguna.
```java
public class Product {
    String productId;
    String productName;
    int productQuantity;
    ...
}
```

#### 8. **Missing Alt Image**

**Permalsahan:** _Tag_ `<img>` yang tidak memiliki _attribute_ `alt`.

**Contoh Isu pada Proyek:**
```html
<img src="https://cdn.vcgamers.com/news/wp-content/uploads/2023/02/PODUSZKA-ROBLOX-MAN-FACE-PREZENT.jpg">
```

**Solusi:** Menambahkan _attribute_ `alt` pada _tag_ `<img>`.
```html
<img src="https://cdn.vcgamers.com/news/wp-content/uploads/2023/02/PODUSZKA-ROBLOX-MAN-FACE-PREZENT.jpg" alt="Roblox Man Face">
```

#### 9. **Method Name Using Snake Case**

**Permasalahan:** Nama _method_ menggunakan _snake case_.

**Contoh Isu pada Proyek:**
```java
void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
    ...
}
```

**Solusi:** Mengubah nama _method_ menggunakan _camel case_.
```java
void createProductPageIsCorrect(ChromeDriver driver) throws Exception {
    ...
}
```

10. **Handle Duplication**

**Permasalahan:** Terdapat duplikasi kode yang tidak perlu seperti pada _unit test_ untuk `ProductRepositoryTest.java`.

**Solusi:** Menggabungkan kode yang duplikat ke dalam satu _method_ yang sama.
```java
Product initiateProduct() {
    Product product = new Product();
    product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
    product.setProductName("Sampo Cap Bambang");
    product.setProductQuantity(100);
    productRepository.create(product);
    return product;
}
```

### CI/CD di Workflow Saya

Saya pikir, saya sudah mengimplementasikan CI/CD pada proyek saya. Saya menggunakan _GitHub Actions_ untuk menjalankan
_workflow_ yang saya buat seperti `ci.yml`, `scorecard`, `sonarcloud.yml`, dan `pmd.yml`. _Workflow-workflow_ ini
secara otomatis akan dijalankan ketika ada _push_ atau _pull request_ ke suatu _branch_. Pada titik ini, saya sudah
menerapkan Continuous Integration (CI). Untuk Continuous Deployment (CD), saya menggunakan _Koyeb_ sebagai _platform_
yang akan secara otomatis _deploy_ aplikasi saya ketika ada _push_ atau _pull request_ ke suatu _branch_.

## Reflection pada  Module Sebelumnya
<details>
<summary>Module 1: Coding Standard</summary>

# Module 1: Coding Standard

## Reflection 1

### Penerapan Prinsip _Clean Code_
**1. _Meaningful Names_**

Saya menggunakan nama yang jelas untuk penamaan variabel, fungsi, kelas, dan argumen dalam tutorial kali ini.
Dengan nama yang jelas tersebut, saya tidak perlu lagi memberikan komentar untuk menjelaskan apa maksud dari
keempat hal tersebut.
Contoh:
```java
@Test
    void testEditQuantityToNegative() {
        Product product = new Product();
        ...
```
**2. _Functions_**

Saya membuat fungsi yang menggunakan nama yang deskriptif, pendek, dan hanya melakukan satu hal. Saya juga
berusaha untuk membuat fungsi yang dapat tampil pada layar saya tanpa harus melakukan _scroll_.

**3. _Comments_**

Saya berusaha untuk membuat komentar yang jelas dan tidak terlalu panjang. Saya juga menghindari penggunaan
komentar bagi kode yang sudah terlihat jelas maksudnya. Selama pengerjaan, saya juga menerapkan "TO-DO"
untuk menandai kode yang belum selesai.

**4. _Objects and Data Structures_**

Salah satu contoh yang saya terapkan yaitu ketika _generate_ string UUID untuk tiap `Product` yang dibuat.
Kode tersebut saya letakkan pada _constructor_ dari `Product` itu sendiri. Hal ini sesuai dengan prinsip OOP
daripada saya meletakkan kode tersebut pada `ProductService.java` atau `ProductRepository.java`.

### Penerapan _Secure Coding_

Praktis yang saya terapkan yaitu _input validation_ ketika membuat sebuah `Product` tanpa sebuah nama atau
ketika jumlahnya bernilai negatif.

### Cara Melakukan _Improve Code_
Hal pertama yang saya lakukan ketika mendapatkan sebuah kesalahan kode yaitu cek forum Discord _Advanced_
Programming. Jika tidak ada, saya akan mencari di _Stack Overflow_ atau _Google_. Apabila masih belum
terpecahkan, saya mencoba untuk menghubungi asisten dosen, terkadang juga bertanya kepada teman. Selama
menunggu jawaban, saya juga tidak jarang untuk mencoba bantuan AI seperti ChatGPT.

## Reflection 2

### Seputar _Unit Test_
1. **Perasaan dalam Membuat _Unit Test_**

Setelah menulis kode _unit test_, saya merasa mudah untuk mencari _bug_ dalam kode saya. Misal, saya
ingin tau apakah kode ketika membuat `Product` saya benar atau tidak. Alih-alih dengan membuka
`localhost:8080/product/create` dan manual memasukkan data, dengan _unit test_, saya cukup menjalankan
_test_-nya saja. Selain itu, _unit test_ membuat saya lebih yakin dengan kode yang saya buat. 

2. **Banyaknya _Test_ yang Diperlukan dalam Sebuah `Class` dan Cara untuk Yakin Bahwa _Test_ Sudah Cukup**

Menurut saya tidak ada batasan seberapa banyak *test* yang perlu kita buat dalam sebuah `class`. Semakin
banyak *test* yang kita buat, semakin baik. Namun, kita juga harus memperhatikan _code coverage_ yang
dibutuhkan. *Code coverage* adalah alat ukur untuk mengukur _test_ yang sudah dibuat oleh _developer_.
Yang pernah saya baca, _rule of thumb_ untuk _code coverage_ yaitu >= 80%.

3. **Arti _Code Coverage_ 100%**

Dengan _code coverage_ 100%, belum tentu menjamin bahwa kode yang kita buat terhindar dari _bugs_ dan
_errors_. Misalkan kita punya kode seperti berikut ini.
```java
public int pangkat (int a, int b) {
    return a * b;
}
```
Dan kita memiliki _test_ seperti dibawah ini.
```java
@Test
void testPangkat() {
    assertEquals(4, pangkat(2, 2));
}
```
Walaupun _test_ tersebut sudah benar dan _code coverage_ terpenuhi, namun ada kasus dimana fungsi
`pangkat` tersebut salah karena tidak sesuai dengan tujuannya. 

### _Clean Code_ pada _Functional Test_
Menurut saya, hal tersebut bukan cara yang baik dalam menerapkan prinsip _clean code_. Tentunya mengurangi
kualitas dari _clean code_-nya. Isu yang muncul ada karena kita **menggunakan suatu prosedur dan variabel yang
sama**. Saran saya, hal tersebut bisa kita **buatkan ke dalam satu 'Class'**. Lalu kita dapat **memisahkan ke dalam fungsi
yang berbeda** untuk setiap _test_ yang kita buat seperti prinsip _Do One Thing_.
</details>