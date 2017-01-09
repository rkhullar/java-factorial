default: clean compile

clean:
	@rm -rf *.class *~

compile: Test.class

test: clean Test.class
	@java Test

%.class: %.java
	@javac $<
