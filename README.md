# Mobile_App (Assignment Project)

A simplistic Android application demonstrating:

- **Bottom Navigation** for multi-screen navigation.
- **Three Fragments** to host different UI and interaction screens.
- **Custom Widgets** beyond standard `TextView`, `EditText`, `Button`, `ImageView`, `RecyclerView`:
  - `SwitchMaterial` (toggle switch)
  - `SeekBar` (slider)
  - `Spinner` (dropdown list)
  - `DatePicker` (calendar picker)
- **Event Handling** for non-click events:
  - `setOnCheckedChangeListener` for switch toggles
  - `setOnSeekBarChangeListener` for slider changes
  - `onItemSelectedListener` for spinner selections
  - `init(...)` listener for date selection
- **Dialog Boxes**
  - Single-choice (`AlertDialog.setSingleChoiceItems`)
  - Text-input (`AlertDialog.setView` with `EditText`)
- **RecyclerView** to display data loaded from a text file (`assets/data.txt`).
- **Implicit Intent** launch of external apps (e.g., Google Maps at predefined coordinates).

---

## Table of Contents

1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Getting Started](#getting-started)
4. [Setup & Run](#setup--run)
5. [Usage](#usage)

---

## Features

- **BottomNavigationView** with three tabs: Home, Widgets, Data.
- **Home Screen**:
  - Feature toggle switch (Material SwitchMaterial).
  - Progress slider (SeekBar).
  - Dialogs: single-choice and input dialog.
  - Launch Google Maps via Intent.
- **Widgets Screen**:
  - Dropdown Spinner.
  - Calendar-style DatePicker.
- **Data Screen**:
  - RecyclerView listing items from a local text file (`assets/data.txt`).

## Tech Stack

- **Language:** Kotlin
- **Minimum SDK:** API 24
- **Compile SDK:** 35
- **Libraries:**
  - AndroidX Core KTX
  - AppCompat
  - Material Components
  - AndroidX Navigation Fragment & UI
  - ConstraintLayout
  - RecyclerView

## Getting Started

### Prerequisites

- Android Studio (Arctic Fox or newer)

### Clone the repository

```bash
git clone https://github.com/your-username/MyApp.git
```

## Setup & Run

1. Open **Android Studio**.
2. Select **File > Open** and choose the project directory.
3. Let Gradle sync and download dependencies.
4. Connect an Android device or start an emulator.
5. Click **Run ▶**.

## Usage

- **Home Tab**:
  - Toggle the switch to enable/disable VUM-Finder™.
  - Drag the slider to change the progress value.
  - Tap **Choose Option** to open a single-choice dialog.
  - Tap **Enter Name** to open a text-input dialog.
  - Tap **Find VUM** to launch Google Maps and find out where VUM is.
- **Widgets Tab**:
  - Select an option from the dropdown spinner.
  - Pick a date on the calendar.
- **Data Tab**:
  - Scroll through the list of items loaded from a text file.
