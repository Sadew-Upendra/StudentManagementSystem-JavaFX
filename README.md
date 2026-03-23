# 🎓 SMS PRO - Student Management Ecosystem

**SMS PRO** is a professional desktop application designed for modern student administration. It combines a high-end **JavaFX** user interface with a robust **Layered Architecture** to provide a seamless management experience.

---

## 🚀 Key Features

* **Modern Sidebar Navigation:** Exact concept-match sidebar with active state indicators and custom symbols.
* **Isometric Dashboard:** A visually rich overview panel featuring isometric educational illustrations.
* **Professional PDF Reporting:** Automated report generation using **iText 8**, including custom logos, headers, and dynamic page numbering.
* **Layered Architecture:** Clean separation of concerns using Controller, Service, DAO, and DTO layers.
* **Dynamic Splash Screen:** Smooth system synchronization with a real-time progress bar and status updates.

---

## 🛠️ Tech Stack

| Technology | Usage |
| :--- | :--- |
| **Java 21** | Core Programming Language |
| **JavaFX 17+** | UI Framework (FXML & CSS) |
| **Maven** | Dependency & Build Management |
| **iText 8** | PDF Generation Engine |
| **MySQL** | Relational Database Management |

---

## 📂 Project Structure

The project follows a strict **Layered Architecture** to ensure maintainability and scalability:

* `com.example.controller` - Handles UI events and navigation logic.
* `com.example.service` - Contains business logic and validation.
* `com.example.dao` - Manages all SQL operations and database interactions.
* `com.example.dto` - Data Transfer Objects for passing data between layers.
* `com.example.util` - Utility classes for PDF generation and DB connectivity.

---

## 🔧 Installation & Setup

1.  **Clone the Repo**
    ```bash
    git clone [https://github.com/Sadew-Upendra/StudentManagementSystem-JavaFX.git](https://github.com/Sadew-Upendra/StudentManagementSystem-JavaFX.git)
    ```

2.  **Database Configuration**
    * Create a MySQL database named `student_ms`.
    * Update `DBConnection.java` with your local `username` and `password`.

3.  **Run with Maven**
    ```bash
    mvn clean javafx:run
    ```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Developed by Sadew Upendra** *Computer Science Undergraduate | University of Kelaniya*