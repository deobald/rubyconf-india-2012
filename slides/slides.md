# slides

!SLIDE

# clojure is my favourite ruby

## steven@c42.in

!SLIDE

# who am I?

!NOTES

here are some notes

!SLIDE

![](images/cowboy-shirt.jpg)

!SLIDE

![](images/gull-lake-map.gif)

!SLIDE

![](images/gull-lake-road.png)

!SLIDE

![](images/not-a-cowboy.jpg)

!SLIDE

![](images/adx.png)
![](images/thoughtworks.jpg)
![](images/drw.png)

!SLIDE

![](images/drw.png)

1. t-logger
2. market data republisher
3. web app + service
4. _trade capture and positions management_

!SLIDE

![](images/c42.png)

!SLIDE

![](images/rubymonk-logo.png)

}}} images/weave.jpg

!SLIDE

# (clojuremonk.com is coming)

!SLIDE

1. baseline
2. optional intro
3. history
4. curiosity
5. good feelings
6. homoiconicity
7. state of the world

!SLIDE

# have you read about clojure?

!SLIDE

# have you tried clojure?

!SLIDE

# have you read some lisp literature?

### (sicp, little schemer, land of lisp, etc.)

!SLIDE

# do you believe this?

@@@ clojure
(= closure object)
@@@

!SLIDE

# (we'll come back to this)

!SLIDE

# intro

!SLIDE

@@@ clojure
(stretch image 128)
@@@

!SLIDE

# function call

!SLIDE

@@@ clojure
(when-not (stretched? image)
  (stretch image 128))
@@@

!SLIDE

# macro call

!SLIDE

# (that's nice, isn't it?)

!SLIDE

@@@ clojure
(defmacro when-not
  "Evaluates test. If logical false, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body]
    (list 'if test nil (cons 'do body)))
@@@

!SLIDE

# "if you want a different for-loop, just write one. you shouldn't have to wait for someone else to do it."

!SLIDE

@@@ clojure
[one two three four]
@@@

!SLIDE

# vector

!SLIDE

@@@ clojure
{ :name  "Steven Deobald"
  :has   "Wood"
  :needs "Gold" }
@@@

!SLIDE

# map

!SLIDE

@@@ clojure
'(one two three four seven)
@@@

!SLIDE

# list

!SLIDE

# history

!SLIDE

# 1958

!SLIDE

![](images/john-mccarthy.gif)

!SLIDE

![](images/steve-russell.jpg)

!SLIDE

![](images/ibm-704.jpg)

!SLIDE

![](images/seymore-cray-1604.jpg)

!SLIDE

# AI: code written in its own data structures

!SLIDE

# 1966 - 1990

!SLIDE

# "AI winter"

!SLIDE

# 1970

!SLIDE

![](images/garbage-collection.jpg)

!SLIDE

# yay, memory management!

!SLIDE

![](images/lisp-machine.jpg)

!SLIDE

# 30 years go by.

!SLIDE

* Stanford LISP
* MACLISP
* InterLisp
* Franz Lisp
* XLISP
* Standard Lisp
* ZetaLisp
* Le Lisp
* Spice Lisp
* NIL
* S-1 Lisp
* Dylan
* EuLisp
* ISLISP
* Scheme
* Common Lisp
* ACL2

!SLIDE

# so, why another lisp? why now?

!SLIDE

# literature

### sicp, reasoned schemer, lisp in small pieces

!SLIDE

# <3 homoiconicity

### a language written in its own data structures may not have beaten the touring test, but it's still a good idea.

!SLIDE

# so, why clojure specifically?

!SLIDE

# concurrency is the new memory management

!SLIDE

# do you have multiple cores in the laptop in front of you?

!SLIDE

# time matters

!SLIDE

![](images/facebook-timeline.jpg)

!SLIDE

![](images/octocat.png)

!SLIDE

# rake db:migrate

!SLIDE

# clojure reference types!

!SLIDE

# atom

@@@ clojure
(def person (atom {:name "Steven"}))
(defn become-ralph [p]
  (assoc p :name "Ralph"))
(swap! person become-ralph)
@@@

!SLIDE

# ref

@@@ clojure
(def person (ref {:name "Steven"}))
(defn become-ralph [p]
  (assoc p :name "Ralph"))
(dosync
  (alter person become-ralph))
@@@

![](images/database.jpg)
