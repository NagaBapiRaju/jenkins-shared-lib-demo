# Jenkins Shared Library Demo

This project demonstrates how to use a Jenkins Shared Library with multiple pipelines.

---

## 🚀 Getting Started

### 1. Fork this Repository

* Click on **Fork**
* Clone your fork locally

---

## 📌 Prerequisites

Make sure the following plugins are installed in Jenkins:

* Pipeline
* Git Plugin
* Pipeline: Groovy Libraries
* Maven Integration Plugin
* Nexus Artifact Uploader

Also ensure:

* JDK 17 is installed and configured in Jenkins

---

## 🏗️ Project Structure

```id="p2y4qa"
vars/
 ├── mavenBuild.groovy
 ├── test.groovy
 └── deploy.groovy
```

---

## ⚙️ Setup Steps

### 2. Configure Shared Library in Jenkins

* Go to: Manage Jenkins → System
* Scroll to: Global Pipeline Libraries
* Add:

  * Name: `my-first-shared-lib`
  * Default branch: `main`
  * Source: Git (your forked repo URL)

---

### 3. Create Pipelines in Jenkins

#### Pipeline 1: Build

* Checkout code
* Call:

```groovy id="a1x8f3"
mavenBuild()
```

---

#### Pipeline 2: Test

* Checkout code
* Call:

```groovy id="z9k2lm"
test()
```

---

#### Pipeline 3: Deploy

* Checkout code
* Build project
* Upload artifact

---

### 4. Configure JDK in Pipeline

```groovy id="b4m9rt"
tools {
    jdk 'jdk17'
}
```

---

### 5. Add Credentials

* Go to: Manage Jenkins → Credentials
* Add credentials (used in pipeline)

---

## ⚠️ Issues Faced & Fixes

### ❌ 1. Shared Library Section Not Visible

* Cause: Missing plugin
* Fix: Install **Pipeline: Groovy Libraries**

---

### ❌ 2. `build()` Error

```id="q3l9we"
Missing required parameter: job
```

* Cause: Name conflict with Jenkins built-in step
* Fix: Rename to `mavenBuild()`

---

### ❌ 3. Git Checkout Error

```id="t7h2yu"
Couldn't find any revision to build
```

* Cause: Wrong branch (`master`)
* Fix: Use `main`

---

### ❌ 4. Java Version Issue

```id="m8c4xp"
release version 17 not supported
```

* Cause: Old JDK
* Fix: Configure JDK 17 in Jenkins

---

### ❌ 5. Artifact Not Found

```id="n5d8as"
file doesn't exist
```

* Cause: Wrong file name/type
* Fix: Match artifact name with build output (`.war` vs `.jar`)

---

## 🧠 Key Learnings

* Shared libraries reduce duplication
* Use meaningful function names
* Always verify build artifacts
* Keep pipelines clean and reusable

---

## ✅ Status

✔ Shared Library configured
✔ Pipelines working
✔ Build and deployment successful

---
