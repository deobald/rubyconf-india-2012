require 'fssm'

INPUT = "slides.md"
OUTPUT = "slides.html"

def fix_codemirror
  header = "<!-- deck.js extension JS files -->"
  cm = '<script src="deck.js/extensions/codemirror/codemirror.js" type="text/javascript"></script>'
  all = File.read("slides.html")
  all.gsub!(cm, "")
  all.gsub!(header, "#{header}\n#{cm}") 
  File.open("slides/#{OUTPUT}", "w") { |f| f.write(all) }
end

def auto
  FSSM.monitor('slides', INPUT) do
    update {|base, relative| generate }
    delete {|base, relative| generate }
    create {|base, relative| generate }
  end
end

def generate
  sh "keydown slides 'slides/#{INPUT}'"
  fix_codemirror
end

desc "Auto-generate keydown slides"
task :auto do
  auto
end

desc "Generate keydown slides"
task :generate do
  generate
end
