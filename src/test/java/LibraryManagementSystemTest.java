import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class LibraryManagementSystemTest {

    // Book Class Tests
    @Test
    public void testBookClassExists() {
        try {
            Class<?> bookClass = Class.forName("Book");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        }
    }

    @Test
    public void testBookHasRequiredFields() {
        try {
            Class<?> bookClass = Class.forName("Book");
            
            Field titleField = bookClass.getDeclaredField("title");
            assertTrue(Modifier.isPrivate(titleField.getModifiers()), "title field should be private");
            assertEquals(String.class, titleField.getType(), "title field should be of type String");
            
            Field authorField = bookClass.getDeclaredField("author");
            assertTrue(Modifier.isPrivate(authorField.getModifiers()), "author field should be private");
            assertEquals(String.class, authorField.getType(), "author field should be of type String");
            
            Field isbnField = bookClass.getDeclaredField("ISBN");
            assertTrue(Modifier.isPrivate(isbnField.getModifiers()), "ISBN field should be private");
            assertEquals(String.class, isbnField.getType(), "ISBN field should be of type String");
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        } catch (NoSuchFieldException e) {
            fail("Book class is missing required field: " + e.getMessage());
        }
    }

    @Test
    public void testBookConstructor() {
        try {
            Class<?> bookClass = Class.forName("Book");
            Constructor<?> constructor = bookClass.getDeclaredConstructor(String.class, String.class, String.class);
            assertNotNull(constructor, "Book should have a constructor with 3 String parameters");
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Book class is missing required constructor: Book(String, String, String)");
        }
    }

    @Test
    public void testBookGetTitleMethod() {
        try {
            Class<?> bookClass = Class.forName("Book");
            Method getTitle = bookClass.getDeclaredMethod("getTitle");
            assertEquals(String.class, getTitle.getReturnType(), "getTitle() should return String");
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Book class is missing required method: getTitle()");
        }
    }

    @Test
    public void testBookGetAuthorMethod() {
        try {
            Class<?> bookClass = Class.forName("Book");
            Method getAuthor = bookClass.getDeclaredMethod("getAuthor");
            assertEquals(String.class, getAuthor.getReturnType(), "getAuthor() should return String");
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Book class is missing required method: getAuthor()");
        }
    }

    @Test
    public void testBookGetISBNMethod() {
        try {
            Class<?> bookClass = Class.forName("Book");
            Method getISBN = bookClass.getDeclaredMethod("getISBN");
            assertEquals(String.class, getISBN.getReturnType(), "getISBN() should return String");
        } catch (ClassNotFoundException e) {
            fail("Book class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Book class is missing required method: getISBN()");
        }
    }

    // Library Class Tests
    @Test
    public void testLibraryClassExists() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Library class does not exist");
        }
    }

    @Test
    public void testLibraryAddBookMethod() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Class<?> bookClass = Class.forName("Book");
            Method addBookMethod = libraryClass.getDeclaredMethod("addBook", bookClass);
            assertNotNull(addBookMethod, "Library should have an addBook method");
        } catch (ClassNotFoundException e) {
            fail("One of the required classes does not exist: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Library class is missing required method: addBook(Book)");
        }
    }

    @Test
    public void testLibraryRemoveBookMethod() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Method removeBookMethod = libraryClass.getDeclaredMethod("removeBook", String.class);
            assertNotNull(removeBookMethod, "Library should have a removeBook method");
        } catch (ClassNotFoundException e) {
            fail("Library class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Library class is missing required method: removeBook(String)");
        }
    }

    @Test
    public void testLibrarySearchBookMethod() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Class<?> bookClass = Class.forName("Book");
            Method searchBookMethod = libraryClass.getDeclaredMethod("searchBook", String.class);
            
            // Check if return type is compatible with an array of Books
            Class<?> returnType = searchBookMethod.getReturnType();
            assertTrue(returnType.isArray() && returnType.getComponentType().equals(bookClass), 
                   "searchBook() should return an array of Book objects");
        } catch (ClassNotFoundException e) {
            fail("One of the required classes does not exist: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Library class is missing required method: searchBook(String)");
        }
    }

    @Test
    public void testLibraryDisplayBooksMethod() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Class<?> bookClass = Class.forName("Book");
            Method displayBooksMethod = libraryClass.getDeclaredMethod("displayBooks");
            
            // Check if return type is compatible with an array of Books
            Class<?> returnType = displayBooksMethod.getReturnType();
            assertTrue(returnType.isArray() && returnType.getComponentType().equals(bookClass), 
                   "displayBooks() should return an array of Book objects");
        } catch (ClassNotFoundException e) {
            fail("One of the required classes does not exist: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Library class is missing required method: displayBooks()");
        }
    }

    @Test
    public void testLibraryConstructor() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Constructor<?> constructor = libraryClass.getDeclaredConstructor();
            assertNotNull(constructor, "Library should have a no-arg constructor");
        } catch (ClassNotFoundException e) {
            fail("Library class does not exist");
        } catch (NoSuchMethodException e) {
            // Having a default constructor is not explicitly required in the spec
            // So this is not necessarily a failure
            System.out.println("Note: Library class does not have an explicit no-arg constructor");
        }
    }

    @Test
    public void testLibraryHasBookCollection() {
        try {
            Class<?> libraryClass = Class.forName("Library");
            Class<?> bookClass = Class.forName("Book");
            
            // Check for ArrayList field (the most likely implementation)
            boolean hasCollection = false;
            for (Field field : libraryClass.getDeclaredFields()) {
                Class<?> fieldType = field.getType();
                if (fieldType.isArray() && fieldType.getComponentType().equals(bookClass)) {
                    hasCollection = true;
                    break;
                } else if (fieldType.getName().contains("ArrayList") || 
                         fieldType.getName().contains("List") || 
                         fieldType.getName().contains("Collection")) {
                    hasCollection = true;
                    break;
                }
            }
            
            assertTrue(hasCollection, "Library should have a collection field to store books");
        } catch (ClassNotFoundException e) {
            fail("One of the required classes does not exist: " + e.getMessage());
        }
    }
}
