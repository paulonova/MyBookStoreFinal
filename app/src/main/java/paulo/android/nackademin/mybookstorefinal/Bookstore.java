package paulo.android.nackademin.mybookstorefinal;


import java.util.ArrayList;
import java.util.List;

public class Bookstore {


    public static List<Book> myBookstore;
    public static List<Book> bookToCart = new ArrayList<>();


    public Bookstore() {
        myBookstore = new ArrayList<>();
        addBooks();
    }


    //public Book(int productId, String prodName, String description, double price)

    public void addBooks() {

        myBookstore.add(new Book(R.drawable.bootstrap_3, "Bootstrap 3.3", "Discover how easy it is to design killer interfaces and responsive websites with the Bootstrap framework. " +
                "This practical book gets you started building pages with Bootstraps HTML/CSS-based tools and design templates right away. " +
                "Youll also learn how to extend your app with interactive features, using its suite of jQuery plugins-often without writing a single line of code.\n" +
                "Developed by Twitter and available free from GitHub, Bootstrap supports responsive design by dynamically adjusting your web page layout. " +
                "With just a basic knowledge of HTML, CSS, and JavaScript, you can build apps that work equally well on desktop screens, smart phones, and tablets. " +
                "This book shows you how.",
                320));

        myBookstore.add(new Book(R.drawable.core_java_v2, "Core Java, Volume II * Advanced Features",
                "Fully updated to reflect Java SE 7 language changes, Core Java, Volume IIAdvanced Features, Ninth Edition, is the definitive guide to " +
                        "Javas most powerful features for enterprise and desktop application development.\n" +
                        "Designed for serious programmers, this reliable, unbiased, no-nonsense tutorial illuminates advanced Java language and library features " +
                        "with thoroughly tested code examples. As in previous editions, all code is easy to understand and displays modern best-practice solutions " +
                        "to the real world challenges faced by professional developers.",
                275));

        myBookstore.add(new Book(R.drawable.javascript_jquery, "JavaScript & jQuery: The Missing Manual",
                "JavaScript lets you supercharge your HTML with animation, interactivity, and visual effects - but many web designers find the language hard to learn. " +
                        "This easy-to-read guide not only covers JavaScript basics, but also shows you how to save time and effort with the jQuery and jQuery UI libraries " +
                        "of pre written JavaScript code. You'll build web pages that feel and act like desktop programs - with little or no programming. The important stuff " +
                        "you need to know: Pull back the curtain on JavaScript. Learn how to build a basic program with this language. Get up to speed on jQuery. \n" +
                        "Quickly assemble JavaScript programs that work well on multiple web browsers. Transform your user interface. Learn jQuery UI, the JavaScript " +
                        "library for interface features like design themes and controls. Make your pages interactive. Create JavaScript events that react to visitor actions. " +
                        "Use animations and effects. Build drop-down navigation menus, pop-ups, automated slideshows, and more. Collect data with web forms. Create easy-to-use " +
                        "forms that ensure more accurate visitor responses. Practice with living examples. Get step-by-step tutorials for web projects you can build yourself.",
                449));

        myBookstore.add(new Book(R.drawable.jquery_mobile, "Creating Mobile Apps with jQuery Mobile",
                "In DetailjQuery Mobile is a touch-optimized web framework (also known as a JavaScript library or a mobile framework) currently being developed by the jQuery project team. " +
                        "The development focuses on creating a framework compatible with a wide variety of smart phones and tablet computers made necessary by the growing but heterogeneous" +
                        " tablet and smartphone market. The jQuery Mobile framework is compatible with other mobile app frameworks and platforms such as PhoneGap, Work light, and more. \n" +
                        "Creating Mobile Apps with jQuery Mobile reflects the author's years of experience and exposes every hidden secret which will ease your mobile app development." +
                        " With just a smattering of design and user experience thrown in, going through this book will allow you to confidently say, \"e;yes, I can do that.\"e;We'll start " +
                        "out with effective mobile prototyping and then move directly to the core of what every one of your mobile sites will need. Then, we'll move on to the fancy stuff. \n" +
                        "After creating some basic business templates and a universal JavaScript, we will move into the more interesting side of mobile development but we always try to " +
                        "keep an eye on progressive enhancement. jQuery Mobile is all about reaching everyone. So is this book.\"e;Creating Mobile Apps with jQuery Mobile\"e; " +
                        "will take your basic mobile knowledge and help you make versatile, unique sites quickly and easily.ApproachWith ample coded examples and screenshots, " +
                        "the book consists of 10 different projects that will help you master jQuery Mobile.Who this book is for\"e;Creating Mobile Apps with jQuery Mobile\"e; " +
                        "assumes a base level knowledge of web development. If you've used jQuery Mobile before, you're gold. Otherwise, you can pick it up along the way.",
                339));

        myBookstore.add(new Book(R.drawable.mysql_developer, "SQL for MySQL Developers",
                "MySQL version 5 offers a SQL dialect with immense power. In SQL for MySQL Developers, Rick F. van der Lans helps you master this version ofSQL and take advantage of " +
                        "its full potential. Using case study examples and hands-on exercises, van der Lans illuminates every key concept,technique, and statement including advanced " +
                        "features that make it easier to create even the most complex statements and programs.\n" +
                        "Drawing on decades of experience as an SQL standards team member and enterprise consultant, he reveals exactly why MySQLs dialect works as it does and how to " +
                        "get the most out of it. You´ll gain powerful insight into everything from basic queries to stored procedures, transactions to data security.\n",
                469));

        myBookstore.add(new Book(R.drawable.sqlite_using, "Using SQLite",
                "Application developers, take note: databases aren't just for the IS group any more. You can build database-backed applications for the desktop, Web, embedded systems," +
                        " or operating systems without linking to heavy-duty client-server databases such as Oracle and MySQL. This book shows you how to use SQLite, a small and lightweight " +
                        "relational database engine that you can build directly into your application. \n" +
                        "With SQLite, you'll discover how to develop a database-backed application that remains manageable in size and complexity. " +
                        "This book guides you every step of the way. You'll get a crash course in data modeling, become familiar with SQLite's dialect of the SQL database language, " +
                        "and much more. ",
                318));

        myBookstore.add(new Book(R.drawable.swift_2, "Swift 2 for Absolute Beginners",
                "Swift 2 for Absolute Beginners is perfect for those with no programming background, those with some programming experience but no object-oriented experience, " +
                        "or those that have a great idea for an app but haven't programmed since school, and it is now updated for Swift 2. Gary Bennett and Brad Lees are full-time " +
                        "professional iOS developers and have developed a broad spectrum of apps for Fortune 500 companies. The authors have taken their combined 12 years of writing apps," +
                        " teaching online iOS courses, the experience from their first three iOS books, along with their online instruction and free online forum at XcelMe.com to create an " +
                        "excellent training book. Many people have a difficult time believing they can learn to write iOS apps or just staying motivated through learning the process. \n" +
                        "This book, along with the free, live online training sessions, helps students stay motivated and overcome obstacles while they learn to be great iOS developers.",
                380));

        myBookstore.add(new Book(R.drawable.the_big_nerd_android, "Android Programming - The Big Nerd Ranch Guide",
                "Android Programming: The Big Nerd Ranch Guide is an introductory Android book for programmers with Java experience.\n" +
                        "Based on Big Nerd Ranch's popular Android Bootcamp course, this guide will lead you through the wilderness using hands-on example apps combined with " +
                        "clear explanations of key concepts and APIs. This book focuses on practical techniques for developing apps compatible with Android 4.1 (Jelly Bean) and up, " +
                        "including coverage of Lollipop and material design.\n" +
                        "Write and run code every step of the way, creating apps that integrate with other Android apps, download and display pictures from the web, " +
                        "play sounds, and more. Each chapter and app has been designed and tested to provide the knowledge and experience you need to get started in Android development.\n",
                265));

        myBookstore.add(new Book(R.drawable.the_big_nerd_ios, "iOS Programming: The Big Nerd Ranch Guide",
                "Updated and expanded to cover iOS 7 and Xcode 5, iOS Programming: The Big Nerd Ranch Guide leads you through the essential concepts, tools, and techniques for developing " +
                        "iOS applications. After completing this book, you will have the know-how and the confidence you need to tackle iOS projects of your own. Based on Big Nerd Ranchs" +
                        " popular iOS Bootcamp course and its well-tested materials and methodology, this bestselling guide teaches iOS concepts and coding in tandem. The result is instruction " +
                        "that is relevant and useful. Throughout the book, the authors explain whats important and share their insights into the larger context of the iOS platform. \n" +
                        "You get a real understanding of how iOS development works, the many features that are available, and when and where to apply what youve learned.",
                440));

        myBookstore.add(new Book(R.drawable.web_design_book, "Web Standards: Mastering HTML5, CSS3, and XML",
                "Web Standards: Mastering HTML5, CSS3, and XML provides solutions to the most common website problems, and gives you a deep understanding of web standards and how they " +
                        "can be applied to improve your website. You will learn how to create fully standards-compliant websites and provide search engine-optimized Web documents with faster " +
                        "download times, accurate rendering, correct appearance and layout, lower development cost, approved accessibility, backward and forward compatibility, " +
                        "and easy maintenance and content updating. The book covers all major Web standards, focusing on syntax, grammar, recommended annotations, and other standardization " +
                        "concerns. Web Standards: Mastering HTML5, CSS3, and XML is also a comprehensive guide to current and future standards for the World Wide Web. \n" +
                        " As a web developer, you'll have seen problems with inconsistent appearance and behavior of the same site in different browsers. " +
                        "Web standards can and should be used to completely eliminate these problems.Web Standards: Mastering HTML5, CSS3, and XML describes how you can make the most " +
                        "of web standards, through technology discussions as well as practical sample code that you can use for your own sites and web applications.It also provides a quick " +
                        "guide to standard website creation for Web developers.",
                370));

    }

    public List<Book> getBooks() {
        return myBookstore;
    }

    public static Book getBookContent(String bookName) {

        for (Book book : myBookstore) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }


    //Methods to CartListActivity
    public static Book getBookToCart(String bookName) {
        for (Book book : bookToCart) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

}