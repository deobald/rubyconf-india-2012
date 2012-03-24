require 'fssm'
include Rake::DSL

task :default => [:auto]

desc "Auto-generate keydown slides"
task :auto do
  auto
end

desc "Generate keydown slides"
task :generate do
  generate
end

def auto
  puts "=== waiting for file changes... ==="
  FSSM.monitor('slides', in_file) do
    update {|base, relative| auto_generate }
    delete {|base, relative| auto_generate }
    create {|base, relative| auto_generate }
  end
end

def auto_generate
  puts "=== #{input} changed. generating... ==="
  generate
  puts "=== ...generated! ===\n\n"
end

def generate
  sh "cd slides && keydown slides '#{in_file}'"
  fix_codemirror_js
  fix_codemirror_css
end

def fix_codemirror_js
  header = "<!-- deck.js extension JS files -->"
  cm = '<script src="deck.js/extensions/codemirror/codemirror.js" type="text/javascript"></script>'
  all = File.read(output)
  all.gsub!(cm, "")
  all.gsub!(header, "#{header}\n#{cm}") 
  File.open(output, "w") { |f| f.write(all) }
end

def fix_codemirror_css
  fontsize = "font-size: 1rem"
  css = File.read(keydown_css)
  css.gsub!(fontsize, "font-size: 1.8rem")
  File.open(keydown_css, "w") { |f| f.write(css) }
end

def slides_dir ; "slides" end
def in_file ; "slides.md" end
def out_file ; "slides.html" end
def input ; "#{slides_dir}/#{in_file}" end
def output ; "#{slides_dir}/#{out_file}" end
def keydown_css ; "#{slides_dir}/css/keydown.css" end
