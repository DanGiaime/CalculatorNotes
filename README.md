# CalculatorNotes
Takes a .txt file with specific formatting, and converts it to TI-BASIC for use on calculator.

**Creating A Program Outline**

The tool I have made relies fundamentally on an outline to create a program. An outline consists of an organized list of what one desires to be in the program, denoting menus/subheadings with &#39;~&#39;. See the example below.

_CALC2_

_~Series_

_~~Sin(x)_

_~~~x - (x^3)/(3!) + (x^5)/(5!) + ... + (x^(2n-1)) / (2n-1!)_

_~~Cos(x)_

_~~~1 - (x^2)/(2!) + (x^4)/(4!) + ... + (x^(2n)) / (2n!)_

_~~e^x_

_~~~1 + x + (x^2)/(2!) + (x^3)/(3!) + ... + (x^n)/(n!)_

_~~1/(1-x)_

_~~~1 + x + x^2 + x^3 + x^4 + ... + x^n_

_~Reimann Sums_

_~~LRAM_

_~~~Sum y(deltax) using the y of the left point for each value. Underapprox when function is decreasing, Overapprox when funciton is increasing._

_~~RRAM_

_~~~Sum y(deltax) using the y of the right point for each value. Overapprox when function is decreasing, Underapprox when funciton is increasing._

_~~MRAM_

_~~~Sum y(deltax) using the y of the midpoint of the two values. Approximation is inconclusive._

_~~TAM_

_~~~(LRAM+RRAM)/2 Underapprox when function is concave down, Overapprox when funciton is concave up._

- **●** The Outline must always start with a title. Do not place any ~ before your title.
- **●** To denote a main menu option, begin with one ~ before the title of that heading. In this case, I wanted &quot;_Series_&quot; and &quot;_Reimann Sums_&quot; to be visible upon first opening the program, so those sections have one ~
- **●** To denote a subheading, place one more ~ than the heading it is under. In this case, I wanted the option &quot;_Sin(x)_&quot; to be under &quot;_Series_&quot; so &quot;_Sin(x)_&quot; has two ~~, because &quot;_Series&quot;_ had one.
- **●** To denote the final piece of information, simply perform the previous step, and put no subheadings underneath it. In this case, &quot;_x - (x^3)/(3!) + (x^5)/(5!) + ... + (x^(2n-1)) / (2n-1!)&quot;_ has three ~, and there is nothing below it with four ~, meaning it must be the last possible option. So, when &quot;_Sin(x)_&quot; is clicked,  &quot;_x - (x^3)/(3!) + (x^5)/(5!) + ... + (x^(2n-1)) / (2n-1!)&quot;_ will display, and the program will end.
- **●**** \*\*Check the next page for important notes on what kinds of characters/sentences will and will not work in the calculator.\*\***

**Things NOT to do**

- **●** Do **NOT** use any special characters other than the following
  - . , ^ ( ) { } [] ! + - \* / &lt; &gt; = :
- **●** Do **NOT** write any formulas that are greater than 15 characters. This will not fit on the calculator screen, and will give an error in the tool. If you need to place any long formulas or words in the calculator, add a space between some of the terms to prevent there from being any 16-character long chain.
- **●** Do **NOT** write invalid links into your program. For example, see the Program below.

_Reimann Sums_

_~LRAM_

_~~Sum y(deltax) using the y of the left point for each value._

_~~~Underapprox when function is decreasing, Overapprox when funciton is increasing._

_~RRAM_

_~~Sum y(deltax) using the y of the right point for each value. Overapprox when function is decreasing, Underapprox when funciton is increasing._

- **●**** This program can not logically run, as the &quot; ****LRAM&quot;**  **section is attempting to make a menu of one item, which is unnecessary. One would first click on &quot;**** Reimann sums ****&quot;**** , **** then on &quot; ****LRAM&quot;**** , at which point we can see the problem. Since there is no other item with three ~, there is no menu, so the subheading underneath &quot;****Sum y(deltax) using the y of the left point for each value. &quot;**  **is unnecessary and will not run, causing the tool not to work.**
- **●** Similarly, do **NOT** make empty menu options. For example, see the program below.

_Reimann Sums_

_~LRAM_

_~RRAM_

- **●** The tool cannot create this program, as there is nothing to create. Upon clicking either option (&quot;_LRAM&quot;_ or &quot;_RRAM&quot;_), there is no text to be displayed / menu to go to. This results in an uncompilable program. In order to avoid this, write out what menus you would like on paper first to ensure you know what should display what.
- **●** Finally, do **NOT** make a menu with more than 7 options. The calculator screen can only fit 7 options into one menu, so either make two outlines or move some items around to account for this.

**Things TO do**

- **●**** DO**use // in place of an integral symbol
- **●**** DO**use 0 in place of a theta symbol
- **●**** DO**use ( ) in formulas. It is difficult to read thing in the calculator at times, so ( ) help to keep everything clear.
- **●**** DO**rganize your information. Keep everything where it should be, don&#39;t just lazily throw the info out there. You will be timed and the ability to quickly and easily get to the information you need is essential.
- **●**** DO**keep things concise. The less you have to say to get the point across, the better. Again, you will be timed, and using abbreviations and keeping definitions simple will help to ensure that your program use is quick and efficient.
- **●**** DO ****HAVE A TITLE!!!** Without a title, your program will not Compile. This title should be short, no more than 16 characters as stated before, but is entirely necessary. The first line of your outline should be this title with no ~ prior.
- **●**** DO USE NOTEPAD TO MAKE YOUR OUTLINE!!!** The tool uses .txt files, not .doc or .docx. Use notepad to create a simple .txt outline.
