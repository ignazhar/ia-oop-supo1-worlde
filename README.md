# ia-oop-supo1-worlde

### Compilation:

```javac -d out WordleGame.java && java -cp out WordleGame```

## Example

```
$ javac -d out WordleGame.java && java -cp out WordleGame
Enter word: (1 out of 6):
mango
---?-
Enter word: (2 out of 6):
print
--+--
Enter word: (3 out of 6):
grind
+-+-+
Enter word: (4 out of 6):
glide
+?+?-
Enter word: (5 out of 6):
guild
+++++
Won game in 5 guesses !!!

Yuliya@Aspire3 MINGW64 /d/Ignat/cam/ia/oop/supo1/wordle (wordle-prototype)
$ javac -d out WordleGame.java && java -cp out WordleGame
Enter word: (1 out of 6):
mango
-???-
Enter word: (2 out of 6):
grand
?-??-
Enter word: (3 out of 6):
dager
Word input error: Word not found in the database
Enter word: (3 out of 6):
wrong
---??
Enter word: (4 out of 6):
anger
+++?-
Enter word: (5 out of 6):
angle
+++++
Won game in 5 guesses !!!
```