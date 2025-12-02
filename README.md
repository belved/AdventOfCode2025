# Advent of Code 2025
![AOC](https://img.shields.io/badge/Advent%20of%20Code-2025-darkgreen)

![Progress](https://img.shields.io/badge/progress-2%2F24%20stars-lightgrey)

![Language](https://img.shields.io/badge/language-Java-red)

## 🎄 Introduction

Welcome to my repo for Advent of Code 2025 !

Here you can find my solutions for every day of the challenge in Java. The idea is not to be as fast as possible nor to have the perfect solution. I just want to practice my development skills. 

To let everyone try to solve the puzzles on their own, my solutions will be posted at least 24 hours later.

## 🎄 What is Advent of Code?
[Advent of Code](https://adventofcode.com/) is an advent calendar created by Eric Wastl where you have a new challenge every day. 

Each day is made in two parts where the second one is usually an adaptation of the first one.
You can use the language you want, there is no rules about that for the challenge. The principal rule is to have fun !  

You can find more information in the [about](https://adventofcode.com/2025/about) page on their website.

## ⚙️ Technical details

- **Language :** Java 21  
- **IDE :** IntelliJ IDEA Community Edition  
- **Unit Test :** JUnit  
- **Dependency management :** Nothing. No Gradle no Maven.

> Each solution can be run directly in the IDE using the main class.  
> The unit tests are only there to check the solution works as expected

## 🗂️ Project architecture

My code is organized like this : 

```
src/
├── daily/
│   ├── Day1.java
│   ├── Day2.java
│   └── ... (one class per day)
│   └── IDay.java
├── data/         # Contains every puzzle input.
├── model/        # Contains the objects created for the solutions
│   ├── Day1/
│   ├── Day2/
│   └── ...       
├── tests/        # Every Unit Tests
├── util/         # Some static class for redundant functions
└── Main.java     # Start solution for every days
```

### Notes :
- Each class `DayX.java` contains the **two solutions** for day X and **has to** implement IDay.java.  
- `data` package is missing from this repo to follow the rule asked by the creator. It contains all the puzzle input (example and my own puzzle).

## 🚀 How to execute project ?

All solutions can be run through your favorite Java IDE (IntelliJ, Eclipse, VSCode, ...).

### Run every solution
1. Open the project in your IDE
2. Open `Main.java` class located in `src/`.
3. Click **Run** to start the program.

### Run a specific day
It is not possible to run a specific day, but if you need, you can run a specific day this way :
1. Open `Main.java` and comment each day except the one you want to run
2. Click **Run** to start the program.

> ⚠️ Note : Puzzle inputs are not included in the `data` package. You'll need to include yours if you want to try the code.

## 📊 Progression

![Progress](https://img.shields.io/badge/Progress-2%2F24-yellow?style=for-the-badge)

Here is the progress for the Advent of Code 2025 !   
You can find the progress of the challenge and some other information.
It will be updated along the event.

---

### 🧮 General statistics

| Statistic                 | Value |
|---------------------------|-------|
| Estimated runtime         | —     |
| Estimated runtime average | —     |
| Fastest day               | —     |
| Slowest day               | —     |

*These information will be completed at the end of Advent of Code*

---

### 🗓️ Daily table

| Day | Part 1 | Part 2 | Time (ms) | Comment |
|------|---------|-----------|--------|------------|-------------|
| 01 | ✔️ | ✔️ | 36 ms | First part was dead simple, second one too, but it blows my mind for many hours to find the solution |
| 02 | ❌ | ❌ | — | |
| 03 | ❌ | ❌ | — | |
| 04 | ❌ | ❌ | — | |
| 05 | ❌ | ❌ | — | |
| 06 | ❌ | ❌ | — | |
| 07 | ❌ | ❌ | — | |
| 08 | ❌ | ❌ | — | |
| 09 | ❌ | ❌ | — | |
| 10 | ❌ | ❌ | — | |
| 11 | ❌ | ❌ | — | |
| 12 | ❌ | ❌ | — | |

## 🎯 Personal objectives

Here is my own goal for this event : 
- Find a solution for **every day**, even if it's not the best solution.
- Get back into the habit of coding regularly.
- Rediscover **Java** after several years away.
- Practice **OOP** again.  
- Write **clean**, **structured**, and **scalable** code.
- Practice TDD again.

> The idea is not to be the best, only to participate 🎄

## 📝 Crédits

🧩 Advent of Code © Eric Wastl

This repository only contains **my own solutions** and does not include official inputs, according to Advent of Code rules.   
If you notice I forgot to delete something that should not be on this repository, please notify me.
