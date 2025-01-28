# News App Project

A modern Android news application built with **Jetpack Compose**, **Retrofit**, and **MVVM architecture**. The app fetches the latest news articles from The Guardian API and displays them in a clean and structured UI.

---

## 📌 Features
- **Fetch & Display News**: Retrieves the latest news articles dynamically.
- **Jetpack Compose UI**: Uses modern declarative UI components.
- **Retrofit API Integration**: Communicates with The Guardian API for fetching news.
- **Article Dialog**: Shows a detailed view of articles.
- **External Browser Support**: Opens full articles in a browser.
- **MVVM Architecture**: Ensures clean code separation.

---

## 🛠️ Tech Stack
- **Kotlin**: Primary language.
- **Jetpack Compose**: UI framework.
- **Retrofit**: REST API networking.
- **MVVM**: Architecture pattern.
- **Material Design 3**: UI components.

---

## 📂 Project Structure
```yaml
com.example.newsappproject
│── data
│   ├── models  # Data models representing API responses
│   │   ├── Article.kt              # Represents a single news article
│   │   ├── NewsResponse.kt         # Represents full API response
│   │   ├── ResponseData.kt         # Encapsulates news list from API
│   ├── remote  # Handles network communication
│   │   ├── NewsApi.kt              # Defines API endpoints using Retrofit
│   │   ├── RetrofitInstance.kt     # Configures Retrofit instance for API calls
│
│── ui
│   ├── components  # Reusable UI components
│   │   ├── ArticleCard.kt          # Displays a single news article in a list
│   │   ├── ArticleDetailScreen.kt  # Full-screen detailed article view
│   │   ├── ArticleDialog.kt        # Pop-up dialog showing article details
│   │   ├── ArticleList.kt          # Displays a list of news articles
│   ├── screens  # App Screens (UI Pages)
│   │   ├── NewsScreen.kt           # Main screen displaying news feed
│
│── theme  # App-wide UI styling
│   ├── Color.kt                    # Defines color scheme
│   ├── Theme.kt                    # Sets up MaterialTheme
│   ├── Type.kt                      # Defines typography styles
│
│── MainActivity.kt  # App's entry point & navigation setup
```

---

## 🚀 Getting Started
1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/NewsApp.git
   ```
   ```bash
   cd NewsApp
   ```
2. Setup API Key. Get your API key from The Guardian API
3. Add it to RetrofitInstance.kt or a secrets.properties file.
4. Open in Android Studi, Build and Run

---

## 📷 Screenshots (Optional)
Add some UI screenshots here.

---

## 🤝 Contribution
Feel free to fork this repository and submit pull requests.

---

## 📝 License
This project is MIT Licensed.
