# Advent of Code 2025
![AOC](https://img.shields.io/badge/Advent%20of%20Code-2025-darkgreen)

![Progress](https://img.shields.io/badge/progress-14%2F24%20stars-lightgrey)

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

![Progress](https://img.shields.io/badge/Progress-14%2F24-yellow?style=for-the-badge)

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

| Day | Part 1 | Part 2 | Time (ms) | Comment                                                                                                                                                                                                                                                                                                                                                                                   |
|-----|-------|-------|-----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 01  | ✔️    | ✔️    | 36 ms     | The first part was dead simple, the second one too, but it blew my mind for no reasons for many hours to find the solution.                                                                                                                                                                                                                                                               |
| 02  | ✔️    | ✔️    | 406 ms    | The logic of the second part was the first one I had in mind when reading the first part, so it wasn't really difficult to find a solution for this one. I think part two could be much faster using some optimizations.                                                                                                                                                                  |
| 03  | ✔️    | ✔️    | 6 ms      | The second part was a nightmare to figure out how to proceed to find the logic for 12 batteries.                                                                                                                                                                                                                                                                                          |
| 04  | ✔️    | ✔️    | 172 ms    | Pretty proud of the solution choose for the first part because the second one was dead simple to adapt with this approach                                                                                                                                                                                                                                                                 |
| 05  | ✔️    | ✔️    | 4 ms      | Pretty happy with the solution found. Second part ask me to readapt my code but it was not that hard to adapt.                                                                                                                                                                                                                                                                            |
| 06  | ✔️    | ✔️    | 7 ms      | Seems to be redundant this year, first part was very simple but it was really difficult to find a way to use what was done for the first part to the second part. <br> **Note : IntelliJ seems to trim the last blank space at the end of a txt file. So, you need to manually add a space if needed at the end of the file to get it to work fine.**                                     |
| 07  | ✔️    | ✔️    | 12 ms     | What a nightmare for the second part! Didn't use recursion for a while and quickly figured out that I won't have a choice this time. Also discovered memoization, a great optimization and easy to use. **Note : I initially planned to check all the paths, but it was too heavy for the RAM. This solution works only for a small amount of data. The solution can be found on the Day7 branch.** |
| 08  | ❌     | ❌     | —         |                                                                                                                                                                                                                                                                                                                                                                                           |
| 09  | ❌     | ❌     | —         |                                                                                                                                                                                                                                                                                                                                                                                           |
| 10  | ❌     | ❌     | —         |                                                                                                                                                                                                                                                                                                                                                                                           |
| 11  | ❌     | ❌     | —         |                                                                                                                                                                                                                                                                                                                                                                                           |
| 12  | ❌     | ❌     | —         |                                                                                                                                                                                                                                                                                                                                                                                           |

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
