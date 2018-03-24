#Directories
SRC = src
DOCDIR = javadoc
BUILD_DIR = build 
LIB_DIR = lib
TEST_DIR = test
RESOURCES = resources

#Add JAR files for testing to classpath
CLASSPATH = build:$(LIB_DIR)/*:$(RECOURCES)/*

#Classes for running
MAIN_CLASS = Main 
TEST_CLASS = TestRunner
TRY_CLASS  = tryBuildTc

#Comands
JAVAC = javac
JAVA = java
JAVAC_FLAGS = -g -d $(BUILD_DIR) -classpath $(CLASSPATH)

all: build

build: clean-build
	@mkdir $(BUILD_DIR) 
	@#cp $(RESOURCES)/* .
	$(JAVAC) -d $(BUILD_DIR) -cp $(CLASSPATH) -sourcepath $(SRC) $(SRC)/*
 

run:
	$(JAVA) -cp $(CLASSPATH) $(MAIN_CLASS)

run_try:
	$(JAVA) -cp $(CLASSPATH) $(TRY_CLASS)


run_test:
		$(JAVA) -cp $(CLASSPATH) $(TEST_CLASS)

clean :
	rm -rf $(BUILD_DIR) ./*.txt $(DOCDIR)

clean-build:
	rm -rf $(BUILD_DIR)

debug:
	jdb -sourcepath $(SRC) $(RESOURCES)/*.java

test: clean-build
	@mkdir $(BUILD_DIR)
	$(JAVAC) $(JAVAC_FLAGS) -sourcepath $(SRC):$(TEST_DIR) $(TEST_DIR)/$(TEST_CLASS).java
	@echo "Running JUnit tests"
	$(JAVA) -cp $(CLASSPATH) $(TEST_CLASS)

doc:
	rm -rf $(DOCDIR)
	@mkdir $(DOCDIR)
	javadoc  $(SRC)/*.java -d $(DOCDIR)
	@echo "Javadoc finished build"

.PHONY: clean #doc run
