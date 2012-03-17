require 'fssm'
include Rake::DSL

desc "Auto-generate keydown slides"
task :auto do
  auto
end

desc "Generate keydown slides"
task :generate do
  generate
end

def auto
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
  sh "keydown slides '#{input}'"
  fix_codemirror
  fix_css
end

def fix_codemirror
  header = "<!-- deck.js extension JS files -->"
  cm = '<script src="deck.js/extensions/codemirror/codemirror.js" type="text/javascript"></script>'
  all = File.read(output)
  all.gsub!(cm, "")
  all.gsub!(header, "#{header}\n#{cm}") 
  File.open(output, "w") { |f| f.write(all) }
end

def fix_css
  sh "rm -rf #{slides_dir}/css"
  sh "mv css #{slides_dir}/css"
end

def slides_dir ; "slides" end
def in_file ; "slides.md" end
def out_file ; "slides.html" end
def input ; "#{slides_dir}/#{in_file}" end
def output ; "#{slides_dir}/#{out_file}" end
