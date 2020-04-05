all: dbg spy rel

dbg:
	$(MAKE) --file=qpcppMakefile all 

rel:
	$(MAKE) CONF=rel --file=qpcppMakefile all 

spy:
	$(MAKE) CONF=spy --file=qpcppMakefile all 

.PHONY : clean
clean:
	$(MAKE) --file=qpcppMakefile clean
