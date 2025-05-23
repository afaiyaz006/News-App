# News App

This is a simple news application that allows users to browse and read news articles from various sources.

## Features

* **Browse News:** View a list of the latest news articles.
* **Filter by Category:** Filter news articles by categories like business, technology, sports, etc.
* **Search Articles:** Search for specific news articles using keywords.
* **Responsive Design:** The app is designed to work well on various screen sizes (desktop, tablet, mobile).

## Technologies Used
* **Kotlin:** The primary programming language for Android development.
* **Jetpack compose** For the whole app ui
* **Ktor Client:** For making HTTP requests to fetch news data from the API.
* **Room Persistence Library:** For local database storage (e.g., caching articles).
* **ViewModel and LiveData:** Part of Android Architecture Components for managing UI-related data in a lifecycle-conscious way.
* **Coroutines:** For asynchronous programming.
* **Manual Dependency Injection:** Managing dependencies without a dedicated library like Dagger or Hilt.
* **Material Components for Android:** For modern UI elements.
* **[NewsAPI.org]:** For fetching news articles.

## Getting Started

### Prerequisites
Get api key from newsapi.org and place it on the local.properties file
NEWS_API_KEY=API_KEY
## Screenshots
<div style="display: flex; flex-direction: row;">
    <img src="https://i.ibb.co/7JnsrXts/ss-app.png"/>
</div>

