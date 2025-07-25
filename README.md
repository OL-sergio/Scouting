# 🏕️ Scounting - Scout Management System

<div align="center">
  <img src="app/src/main/res/mipmap-hdpi/ic_launcher.png" alt="Scounting Logo" width="120" height="120">
  
  [![Android](https://img.shields.io/badge/Platform-Android-green.svg?style=flat&logo=android)](https://developer.android.com)
  [![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
  [![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
  [![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](LICENSE)
</div>

## 📋 Table of Contents
- [Description](#-description)
- [Project Objectives](#-project-objectives)
- [Features](#-features)
- [Technologies & Frameworks](#-technologies--frameworks)
- [Project Structure](#-project-structure)
- [Class Documentation](#-class-documentation)
- [Installation & Setup](#-installation--setup)
- [Configuration](#-configuration)
- [Screenshots](#-screenshots)
- [Contributing](#-contributing)

## 📖 Description

**Scounting** is a comprehensive Android application designed for managing scout organizations. The app provides a complete solution for scout group administration, including member management, staff coordination, and activity planning. Built with modern Android development practices using Kotlin, the application offers an intuitive interface for scout leaders and administrators to efficiently manage their groups.

The application serves as a digital platform to streamline scout management processes, replacing traditional paper-based systems with a modern, mobile-first approach.

## 🎯 Project Objectives

- **Digital Transformation**: Modernize scout group management by transitioning from manual processes to digital solutions
- **Member Management**: Provide comprehensive tools for managing scout and staff member information
- **Activity Coordination**: Facilitate planning, creation, and management of scout activities and events
- **Data Centralization**: Create a centralized database for all scout-related information
- **User Authentication**: Implement secure login and registration systems
- **Mobile Accessibility**: Ensure the system is accessible on mobile devices for field use
- **Scalability**: Design the system to accommodate growing scout groups and multiple locations

## ✨ Features

### 👥 User Management
- **User Registration & Authentication**: Secure signup and login system
- **Role-based Access**: Different access levels for scouts, staff, and administrators
- **Profile Management**: Complete user profile with personal information

### 🏃 Scout Management
- **Scout Registration**: Add new scouts with complete information
- **Scout Profiles**: Detailed profiles including personal data, contact information
- **Scout Directory**: Browse and search through all registered scouts

### 👨‍💼 Staff Management
- **Staff Registration**: Register new staff members and leaders
- **Staff Profiles**: Comprehensive staff information management
- **Staff Directory**: Easy access to staff member details

### 🏃‍♂️ Activity Management
- **Activity Creation**: Create and plan new scout activities
- **Activity Details**: Comprehensive activity information including dates, locations
- **Activity Listing**: View all planned and past activities
- **Activity Updates**: Modify existing activity information

### 🌐 Network Integration
- **Backend Connectivity**: Seamless integration with backend services
- **Data Synchronization**: Real-time data sync across devices
- **Offline Support**: Basic functionality available offline

## 🛠 Technologies & Frameworks

### 🔧 Core Technologies
| Technology | Description | Version |
|------------|-------------|---------|
| ![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white) | Primary programming language | Latest |
| ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) | Target platform | API 19-30 |
| ![Material Design](https://img.shields.io/badge/Material_Design-757575?style=for-the-badge&logo=material-design&logoColor=white) | UI Design system | 1.4.0 |

### 📚 Android Libraries & Frameworks
| Library | Purpose | Version |
|---------|---------|---------|
| ![AndroidX](https://img.shields.io/badge/AndroidX-3DDC84?style=flat&logo=android) **Core KTX** | Kotlin extensions for Android | 1.5.0 |
| ![AppCompat](https://img.shields.io/badge/AppCompat-3DDC84?style=flat&logo=android) **AppCompat** | Backward compatibility | 1.3.0 |
| ![ConstraintLayout](https://img.shields.io/badge/ConstraintLayout-3DDC84?style=flat&logo=android) **ConstraintLayout** | Advanced layouts | 2.0.4 |
| ![Navigation](https://img.shields.io/badge/Navigation-3DDC84?style=flat&logo=android) **Navigation Component** | App navigation | 2.3.5 |
| ![ViewBinding](https://img.shields.io/badge/ViewBinding-3DDC84?style=flat&logo=android) **View Binding** | Type-safe view references | Built-in |

### 🌐 Networking & Data
| Library | Purpose | Version |
|---------|---------|---------|
| ![Volley](https://img.shields.io/badge/Volley-FF6F00?style=flat&logo=android) **Volley** | HTTP networking | 1.2.0 |
| ![OkHttp](https://img.shields.io/badge/OkHttp-3F51B5?style=flat&logo=square) **OkHttp** | HTTP client | 4.9.0 |
| ![Glide](https://img.shields.io/badge/Glide-00C853?style=flat) **Glide** | Image loading | 4.11.0 |

### 🔨 Build Tools
| Tool | Purpose | Version |
|------|---------|---------|
| ![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle) **Gradle** | Build automation | 6.7.1 |
| ![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=flat&logo=android-studio) **Android Studio** | IDE | Latest |

## 📁 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/ipca/am/scounting/
│   │   │   ├── helpers/          # Helper and utility classes
│   │   │   │   ├── Backend.kt    # Backend communication utilities
│   │   │   │   └── VolleyHelper.kt # Network request helper
│   │   │   ├── login/            # Authentication activities
│   │   │   │   ├── LoginActivity.kt     # User login
│   │   │   │   └── RegisterActivity.kt  # User registration
│   │   │   ├── main/             # Main application activities
│   │   │   │   ├── ActivitiesDetailActivity.kt    # Activities list
│   │   │   │   ├── CreateActivitiesActivity.kt    # Create activities
│   │   │   │   ├── CreateNewActivitiesActivity.kt # Alternative activity creation
│   │   │   │   ├── CreateScout.kt                 # Scout creation
│   │   │   │   ├── CreateStaff.kt                 # Staff creation
│   │   │   │   ├── DetailScout.kt                 # Scout details
│   │   │   │   └── DetailStaff.kt                 # Staff details
│   │   │   └── models/           # Data models
│   │   │       ├── ActivitiesModel.kt     # Activity data model
│   │   │       ├── ActivitiesModelV2.kt   # Enhanced activity model
│   │   │       ├── ScoutModel.kt          # Scout data model
│   │   │       ├── StaffModel.kt          # Staff data model
│   │   │       └── UsersModel.kt          # User data model
│   │   ├── res/                  # Resources
│   │   │   ├── drawable/         # Vector drawables and icons
│   │   │   ├── layout/           # XML layout files
│   │   │   ├── menu/             # Menu resources
│   │   │   ├── mipmap/           # App icons
│   │   │   ├── values/           # Strings, colors, themes
│   │   │   └── values-night/     # Dark theme resources
│   │   └── AndroidManifest.xml   # App configuration
│   ├── androidTest/              # Instrumented tests
│   └── test/                     # Unit tests
├── build.gradle                  # Module build configuration
└── proguard-rules.pro           # ProGuard configuration
```

## 📚 Class Documentation

### 🏗️ Helper Classes

#### `VolleyHelper.kt`
**Purpose**: Manages all network communications using the Volley library.

**Key Methods**:
- `getActivities()`: Retrieves activities from the server
- `userLogin()`: Handles user authentication
- Network request management and response handling

**Responsibilities**:
- HTTP request/response management
- JSON parsing and error handling
- Asynchronous network operations

#### `Backend.kt`
**Purpose**: Additional backend communication utilities using OkHttp.

**Key Features**:
- Alternative HTTP client implementation
- Coroutine-based asynchronous operations
- JSON request body creation

### 🔐 Authentication Classes

#### `LoginActivity.kt`
**Purpose**: Handles user authentication and login functionality.

**Key Features**:
- User credential validation
- Secure login process
- Navigation to main application screens
- Error handling for invalid credentials

**UI Components**:
- Username/email input field
- Password input field
- Login button
- Registration link

#### `RegisterActivity.kt`
**Purpose**: Manages new user registration process.

**Key Features**:
- New user account creation
- Input validation
- User data collection
- Integration with backend registration API

### 🏠 Main Application Classes

#### `ActivitiesDetailActivity.kt`
**Purpose**: Main screen displaying the list of all scout activities.

**Key Features**:
- Activities list display using ListView
- Custom adapter for activity items
- Activity data fetching from server
- Navigation to individual activity details

**Components**:
- `ActivitiesAdapter`: Custom adapter for displaying activities
- List view management
- JSON data parsing and display

#### `CreateActivitiesActivity.kt` & `CreateNewActivitiesActivity.kt`
**Purpose**: Screens for creating new scout activities.

**Key Features**:
- Activity information input forms
- Data validation
- Server communication for activity creation
- User interface for activity details

#### `CreateScout.kt`
**Purpose**: Form for registering new scout members.

**Key Features**:
- Scout personal information collection
- Input field validation
- Scout data persistence
- Integration with scout management system

#### `CreateStaff.kt`
**Purpose**: Form for registering new staff members.

**Key Features**:
- Staff information collection
- Role assignment capabilities
- Staff data management
- Backend integration for staff creation

#### `DetailScout.kt`
**Purpose**: Displays comprehensive information about a specific scout.

**Key Features**:
- Scout profile viewing
- Personal information display
- Scout activity history
- Edit capabilities for scout data

#### `DetailStaff.kt`
**Purpose**: Shows detailed information about staff members.

**Key Features**:
- Staff profile management
- Responsibility and role display
- Staff activity tracking
- Profile editing capabilities

### 📊 Model Classes

#### `ScoutModel.kt`
**Purpose**: Data model representing scout member information.

**Properties**:
- `idScout: Int?` - Unique scout identifier
- `name: String?` - Scout's full name
- `birthdate: String?` - Date of birth
- `country: String?` - Nationality/country
- `email: String?` - Contact email
- `phone: Int?` - Phone number
- `creationDate: String?` - Registration date

**Key Methods**:
- `parseJson()`: Converts JSON data to ScoutModel object
- Companion object for static parsing functionality

#### `StaffModel.kt`
**Purpose**: Data model for staff member information.

**Properties**:
- `idStaff: Int?` - Unique staff identifier
- `name: String?` - Staff member's name
- `birthdate: String?` - Date of birth
- `country: String?` - Nationality
- `email: String?` - Contact email
- `phone: Int?` - Phone number
- `creationDate: String?` - Date joined

**Key Methods**:
- `parseJson()`: JSON to object conversion
- Staff data management utilities

#### `ActivitiesModel.kt`
**Purpose**: Data model for scout activities and events.

**Properties**:
- `activitiesName: String?` - Activity name
- `activitiesStartDate: String?` - Start date and time
- `activitiesAddress: String?` - Location address
- `activitiesCity: String?` - City location
- `activitiesCountry: String?` - Country
- `activitiesEmail: String?` - Contact email
- `activitiesPhone: String?` - Contact phone

**Key Methods**:
- `parseJSON()`: Converts server response to model
- Activity data representation

#### `ActivitiesModelV2.kt`
**Purpose**: Enhanced version of the activities model with additional features.

**Key Features**:
- Extended activity properties
- Enhanced JSON handling
- Additional functionality for complex activities

#### `UsersModel.kt`
**Purpose**: User account data model for authentication and user management.

**Key Features**:
- User authentication data
- Profile information management
- Session management support

## 🚀 Installation & Setup

### 📋 Prerequisites

- **Android Studio**: Latest version (Arctic Fox 2020.3.1 or later)
- **Java Development Kit (JDK)**: JDK 8 or higher
- **Android SDK**: API level 19-30
- **Git**: For version control
- **Minimum Android Version**: Android 4.4 (API 19)
- **Target Android Version**: Android 11 (API 30)

### 🐙 GitHub Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/OL-sergio/Scouting.git
   cd Scouting
   ```

2. **Create a New Branch** (for development)
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Check Project Structure**
   ```bash
   ls -la
   # Verify you see: app/, gradle/, gradlew, settings.gradle
   ```

### 🔧 Android Studio Setup

1. **Open Project in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned `Scouting` directory
   - Click "OK"

2. **Gradle Sync**
   - Android Studio will automatically start Gradle sync
   - Wait for sync to complete
   - If sync fails, try: `Build > Clean Project` then `Build > Rebuild Project`

3. **SDK Configuration**
   - Go to `File > Project Structure > Modules`
   - Ensure the following SDK versions:
     - Compile SDK Version: 30
     - Min SDK Version: 19
     - Target SDK Version: 30

4. **Dependencies Check**
   - Open `app/build.gradle`
   - Verify all dependencies are properly resolved
   - Run `Tools > Android > Sync Project with Gradle Files` if needed

5. **Build Configuration**
   ```bash
   # In Android Studio terminal or external terminal:
   ./gradlew clean
   ./gradlew build
   ```

### 📱 Running the Application

1. **Using Android Emulator**
   - Go to `Tools > AVD Manager`
   - Create a new Virtual Device (API 19+ recommended)
   - Start the emulator
   - Click the "Run" button in Android Studio

2. **Using Physical Device**
   - Enable Developer Options on your Android device
   - Enable USB Debugging
   - Connect device via USB
   - Select your device in the device dropdown
   - Click "Run"

3. **Build APK**
   ```bash
   # Debug APK
   ./gradlew assembleDebug
   
   # Release APK (requires signing configuration)
   ./gradlew assembleRelease
   ```

## ⚙️ Configuration

### 🌐 Network Configuration

1. **Backend URL Configuration**
   - Open `app/src/main/java/ipca/am/scounting/helpers/Backend.kt`
   - Update the `BASE_API` constant with your server URL:
   ```kotlin
   val BASE_API = "http://your-server-url:port"
   ```

2. **Volley Configuration**
   - Network requests are configured in `VolleyHelper.kt`
   - Modify endpoints and request parameters as needed

### 🔒 Permissions Configuration

The app requires the following permissions (already configured in `AndroidManifest.xml`):

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

### 🎨 UI Configuration

1. **Themes and Colors**
   - Light theme: `app/src/main/res/values/themes.xml`
   - Dark theme: `app/src/main/res/values-night/themes.xml`
   - Colors: `app/src/main/res/values/colors.xml`

2. **Strings Localization**
   - Default strings: `app/src/main/res/values/strings.xml`
   - Add additional language support by creating `values-[language]/strings.xml`

### 🔧 Build Configuration

1. **Application ID**: `ipca.am.scounting`
2. **Version Configuration** (in `app/build.gradle`):
   ```gradle
   defaultConfig {
       applicationId "ipca.am.scounting"
       minSdkVersion 19
       targetSdkVersion 30
       versionCode 1
       versionName "1.0"
   }
   ```

3. **ProGuard Configuration**
   - Rules defined in `app/proguard-rules.pro`
   - Enabled for release builds to optimize and obfuscate code

### 🗄️ Database Configuration

Currently, the app uses remote server communication. To configure local database:

1. Add Room dependencies to `build.gradle`
2. Create database entities and DAOs
3. Configure database initialization in Application class

## 📸 Screenshots

> **Note**: Add screenshots of your application here to showcase the user interface and functionality.

### 🔐 Authentication Screens
![Login Screen](screenshots/login_screen.png)
*User login interface with username and password fields*

![Registration Screen](screenshots/register_screen.png)
*New user registration form*

### 🏠 Main Application Screens
![Activities List](screenshots/activities_list.png)
*Main screen showing all scout activities*

![Create Activity](screenshots/create_activity.png)
*Form for creating new activities*

### 👥 Member Management
![Scout Profile](screenshots/scout_profile.png)
*Individual scout member profile*

![Staff Management](screenshots/staff_management.png)
*Staff member management interface*

## 🤝 Contributing

We welcome contributions to the Scounting project! Please read our [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines on how to contribute.

### 🔄 Quick Start for Contributors

1. **Fork the Repository**
   ```bash
   git clone https://github.com/your-username/Scouting.git
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/amazing-new-feature
   ```

3. **Make Your Changes**
   - Follow the existing code style
   - Add tests for new functionality
   - Update documentation as needed

4. **Submit a Pull Request**
   - Provide a clear description of changes
   - Reference any related issues
   - Ensure all tests pass

### 📝 Development Guidelines

- **Code Style**: Follow Kotlin coding conventions
- **Testing**: Add unit tests for new functionality
- **Documentation**: Update docs for significant changes
- **Security**: Follow security best practices

For detailed guidelines, see [CONTRIBUTING.md](CONTRIBUTING.md).

### 🐛 Reporting Issues

Found a bug? Please create an issue on GitHub with:
- Clear description and steps to reproduce
- Expected vs actual behavior
- Device and Android version information
- Screenshots if applicable

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📚 Additional Documentation

- **[CONTRIBUTING.md](CONTRIBUTING.md)**: Contribution guidelines and development setup
- **[CHANGELOG.md](CHANGELOG.md)**: Project changelog and release notes
- **[Screenshots README](screenshots/README.md)**: Guidelines for application screenshots

---

<div align="center">
  <p>Made with ❤️ for the Scout Community</p>
  <p>
    <a href="#-scounting---scout-management-system">Back to Top</a>
  </p>
</div>