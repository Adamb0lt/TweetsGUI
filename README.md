# TweetsProj - Twitter Data Visualization

![Project Logo](https://github.com/Adamb0lt/TweetsGUI/assets/122646712/87b020ea-f725-49d9-8fa8-79eac0d63510)
 <!-- Include a project logo or screenshot if available -->

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Usage](#usage)

## Introduction

TweetsProj is a Java-based project that provides a GUI for reading and visualizing information from Twitter data stored in a CSV file. This project includes three main components:
1. **MakeTweetsArray**: A Java class that reads and processes Twitter data from a CSV file, creating Tweet objects and calculating various statistics.
2. **Tweets**: A Java class that defines the Tweet object with methods to set, get, and format Tweet attributes.
3. **TweetWindow**: A JavaFX GUI application that allows users to search for and view Twitter data using MakeTweetsArray and visualize it using the Tweets class.

## Features

- Load Twitter data from a CSV file into Tweet objects.
- Search for and display details of individual Tweets.
- Visualize various statistics about the Twitter data.
- Simple and intuitive user interface.

## Usage

- Launch the TweetWindow GUI application by following the installation steps above.
- Enter the index of the Tweet you want to view and click the "Search" button.
- The details of the selected Tweet will be displayed in the text area.
- You can clear the input and output fields using the "Clear" button.
- To exit the application, click the "Exit" button.

Note: The program will only showcase valid tweets, and tweets with errors or mistakes will not be shown. You can experiment with different tweet indices to observe the program's ability to display valid tweets and inform the user when a non-valid tweet cannot be displayed.


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed on your system.
- A CSV file containing Twitter data (e.g., `shortchatgpt.txt`) in the project directory.

You can download a sample CSV file from the following link:
[Download CSV file](https://www.kaggle.com/datasets/manishabhatt22/tweets-onchatgpt-chatgpt?resource=download)
