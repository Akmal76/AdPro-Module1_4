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

### Definisi CI/CD di Workflow Saya

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