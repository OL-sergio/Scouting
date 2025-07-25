# Contributing to Scounting

Thank you for your interest in contributing to the Scounting project! This document provides guidelines and information for contributors.

## 🌟 How to Contribute

### 🔍 Ways to Contribute

- **🐛 Bug Reports**: Help us identify and fix bugs
- **✨ Feature Requests**: Suggest new features or improvements
- **📝 Documentation**: Improve documentation and examples
- **💻 Code Contributions**: Submit bug fixes or new features
- **🎨 UI/UX Improvements**: Enhance user interface and experience
- **🧪 Testing**: Help test the application on different devices
- **🌐 Translations**: Add support for additional languages

### 📋 Getting Started

1. **Fork the Repository**
   ```bash
   git clone https://github.com/your-username/Scouting.git
   cd Scouting
   ```

2. **Set Up Development Environment**
   - Install Android Studio (latest version)
   - Install JDK 8 or higher
   - Configure Android SDK (API 19-30)

3. **Create a Branch**
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b bugfix/issue-description
   ```

## 📝 Development Guidelines

### 🏗️ Code Style

- **Language**: Kotlin (primary), Java (legacy support)
- **Naming Conventions**: Follow Kotlin conventions
  - Classes: PascalCase (`ScoutModel`)
  - Functions: camelCase (`createScout()`)
  - Variables: camelCase (`scoutName`)
  - Constants: UPPER_SNAKE_CASE (`BASE_URL`)

- **File Organization**:
  - One class per file
  - Organize imports alphabetically
  - Remove unused imports

### 🧪 Testing Requirements

- **Unit Tests**: Add tests for new functionality
- **Integration Tests**: Test component interactions
- **UI Tests**: Test user interface flows
- **Performance Tests**: Ensure app performance

```kotlin
// Example test structure
@Test
fun `should create scout with valid data`() {
    val scout = ScoutModel()
    scout.name = "Test Scout"
    scout.email = "test@example.com"
    
    assertNotNull(scout.name)
    assertTrue(scout.email!!.contains("@"))
}
```

### 📚 Documentation Standards

- **Class Documentation**: Document all public classes
- **Method Documentation**: Explain complex methods
- **README Updates**: Update README for significant changes
- **Code Comments**: Use clear, concise comments

```kotlin
/**
 * Manages scout member data and operations
 * 
 * @property idScout Unique identifier for the scout
 * @property name Full name of the scout member
 */
class ScoutModel {
    var idScout: Int? = null
    var name: String? = null
    
    /**
     * Parses JSON data and creates ScoutModel instance
     * 
     * @param jsonArticle JSON object containing scout data
     * @return ScoutModel instance with parsed data
     */
    companion object {
        fun parseJson(jsonArticle: JSONObject): ScoutModel {
            // Implementation
        }
    }
}
```

## 🔄 Pull Request Process

### 📋 Before Submitting

1. **Test Your Changes**
   ```bash
   ./gradlew test
   ./gradlew build
   ```

2. **Check Code Style**
   - Use Android Studio's code formatter
   - Remove unused imports
   - Follow naming conventions

3. **Update Documentation**
   - Update README.md if needed
   - Add inline documentation
   - Update CHANGELOG.md

### 📬 Submitting Pull Request

1. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "feat: add scout profile editing functionality"
   ```

2. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

3. **Create Pull Request**
   - Go to GitHub and create a new pull request
   - Use a descriptive title
   - Fill out the pull request template
   - Reference any related issues

### 📋 Pull Request Template

```markdown
## Description
Brief description of changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Performance improvement
- [ ] Code refactoring

## Testing
- [ ] Unit tests pass
- [ ] Integration tests pass
- [ ] Manual testing completed
- [ ] Tested on multiple devices/API levels

## Screenshots (if applicable)
Add screenshots to show UI changes.

## Checklist
- [ ] Code follows project style guidelines
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] Tests added/updated
```

## 🐛 Issue Reporting

### 🔍 Bug Reports

When reporting bugs, include:

- **Device Information**: Model, Android version, API level
- **App Version**: Version name and code
- **Steps to Reproduce**: Clear step-by-step instructions
- **Expected Behavior**: What should happen
- **Actual Behavior**: What actually happens
- **Screenshots/Logs**: Visual evidence or error logs

### 💡 Feature Requests

For feature requests, include:

- **Problem Description**: What problem does this solve?
- **Proposed Solution**: How should it work?
- **Alternatives Considered**: Other possible solutions
- **Additional Context**: Screenshots, mockups, references

## 🏗️ Architecture Guidelines

### 📁 Project Structure

Follow the established project structure:

```
app/src/main/java/ipca/am/scounting/
├── helpers/          # Utility and helper classes
├── login/           # Authentication related activities
├── main/            # Main application activities
└── models/          # Data models and entities
```

### 🎯 Design Patterns

- **MVVM**: Use Model-View-ViewModel for complex screens
- **Repository Pattern**: For data access abstraction
- **Singleton**: For application-wide instances (VolleyHelper)
- **Observer Pattern**: For UI updates and data binding

### 🌐 Network Architecture

- **Primary**: Volley for HTTP requests
- **Secondary**: OkHttp for advanced networking needs
- **Error Handling**: Comprehensive error handling and user feedback
- **Offline Support**: Cache important data locally

## 🧪 Testing Guidelines

### 📋 Testing Types

1. **Unit Tests** (`src/test/`)
   ```kotlin
   @Test
   fun testScoutModelParsing() {
       val json = JSONObject()
       json.put("NAME", "Test Scout")
       
       val scout = ScoutModel.parseJson(json)
       assertEquals("Test Scout", scout.name)
   }
   ```

2. **Integration Tests** (`src/androidTest/`)
   ```kotlin
   @Test
   fun testLoginFlow() {
       onView(withId(R.id.edtTex_LoginUsername))
           .perform(typeText("testuser"))
       
       onView(withId(R.id.btn_loginUser))
           .perform(click())
   }
   ```

### 🎯 Testing Best Practices

- **AAA Pattern**: Arrange, Act, Assert
- **Descriptive Names**: Use clear test method names
- **Test Data**: Use mock data for consistent testing
- **Edge Cases**: Test boundary conditions and error scenarios

## 🌐 Localization

### 🗣️ Adding Languages

1. **Create Resource Directory**
   ```
   app/src/main/res/values-[language]/
   ```

2. **Translate Strings**
   ```xml
   <!-- values-pt/strings.xml -->
   <resources>
       <string name="app_name">Escotismo</string>
       <string name="login">Entrar</string>
   </resources>
   ```

3. **Test Translation**
   - Test on devices with different languages
   - Verify UI layout with longer text
   - Ensure cultural appropriateness

## 🔒 Security Guidelines

### 🛡️ Security Best Practices

- **Input Validation**: Validate all user inputs
- **Data Encryption**: Encrypt sensitive data
- **Network Security**: Use HTTPS for all communications
- **Authentication**: Implement secure login mechanisms
- **Permissions**: Request minimal necessary permissions

### 🔐 Code Security

```kotlin
// ✅ Good: Input validation
fun validateEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

// ✅ Good: Secure storage
private fun saveSecureData(key: String, value: String) {
    val sharedPrefs = getSharedPreferences("secure_prefs", Context.MODE_PRIVATE)
    sharedPrefs.edit().putString(key, encrypt(value)).apply()
}
```

## 📞 Support and Communication

### 💬 Getting Help

- **GitHub Issues**: For bug reports and feature requests
- **GitHub Discussions**: For questions and general discussion
- **Documentation**: Check README.md and inline documentation
- **Code Comments**: Read existing code for implementation guidance

### 🤝 Community Guidelines

- **Be Respectful**: Treat all contributors with respect
- **Be Constructive**: Provide helpful feedback and suggestions
- **Be Patient**: Allow time for reviews and responses
- **Be Collaborative**: Work together to improve the project

## 🏆 Recognition

Contributors will be recognized in:

- **README.md**: Contributors section
- **Release Notes**: Acknowledgment in version releases
- **GitHub**: Contributor statistics and achievements

## 📄 License

By contributing to Scounting, you agree that your contributions will be licensed under the same license as the project.

---

Thank you for contributing to Scounting! 🏕️✨